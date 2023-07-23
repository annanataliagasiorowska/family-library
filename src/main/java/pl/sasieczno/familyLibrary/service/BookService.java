package pl.sasieczno.familyLibrary.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sasieczno.familyLibrary.model.Book;
import pl.sasieczno.familyLibrary.BookSummaryDto;
import pl.sasieczno.familyLibrary.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookService {

    private final BookRepository booksRepository;

    public BookService(BookRepository booksRepository) {
        this.booksRepository = booksRepository;
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

    public List<Book> searchByPhraseInTitle(String phrase) {
        return booksRepository.findByTitleContainingIgnoreCase(phrase);
    }


    public void addBook(Book book) {

        booksRepository.save(book);
    }
}
