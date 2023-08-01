package pl.sasieczno.familyLibrary.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sasieczno.familyLibrary.dto.BookDto;
import pl.sasieczno.familyLibrary.dto.BookSummaryDto;
import pl.sasieczno.familyLibrary.model.Book;
import pl.sasieczno.familyLibrary.model.Library;
import pl.sasieczno.familyLibrary.repository.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookService {

    private final BookRepository booksRepository;
    private final OwnerRepository ownerRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final PlaceRepository placeRepository;

    public BookService(
            BookRepository booksRepository,
            OwnerRepository ownerRepository,
            AuthorRepository authorRepository,
            GenreRepository genreRepository, PlaceRepository placeRepository) {
        this.booksRepository = booksRepository;
        this.ownerRepository = ownerRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
        this.placeRepository = placeRepository;
    }

    public List<BookSummaryDto> getSorted(String sortCriteria) {
        List<Book> sortedBooks = switch(sortCriteria) {
            case "author" -> booksRepository.findAllByOrderByAuthorLastNameAsc();
            case "title" -> booksRepository.findAllByOrderByTitleAsc();

            default -> throw new IllegalStateException("Unexpected value: " + sortCriteria);
        };
        return sortedBooks.stream()
                .map(book -> new BookSummaryDto(
                        book.getTitle(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName(),
                        book.getReleaseYear()
                ))
                .collect(Collectors.toList());
    }

    public List<BookSummaryDto> searchByPhraseInTitle(String phrase) {
        List<Book> booksByPhrase = booksRepository.findByTitleContainingIgnoreCase(phrase);
        return booksByPhrase.stream()
                .map(book -> new BookSummaryDto(
                        book.getTitle(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName(),
                        book.getReleaseYear()
                ))
                .collect(Collectors.toList());
    }


    public void addBook(BookDto book, Integer ownerId) {
        // find library by owner id, validate place id
        Library library = ownerRepository.findLibraryByOwnerId(ownerId);
        Book newBook = new Book();
        newBook.setLibrary(library);
        newBook.setTitle(book.getTitle());
        newBook.setAuthor(authorRepository.findById(book.getAuthorId()).orElse(null));
        newBook.setGenre(genreRepository.findById(book.getGenreId()).orElse(null));
        newBook.setPlace(placeRepository.findById(book.getPlaceId()).orElse(null));
        newBook.setRating(book.getRating() != null ? book.getRating() : null);
        newBook.setInternalRating((book.getInternalRating() != null ? book.getInternalRating() : null));
        newBook.setReleaseYear(book.getReleaseYear());
        booksRepository.save(newBook);
    }

    public void updateBook(Integer bookId) {

    }
}
