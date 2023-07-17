package pl.sasieczno.familyLibrary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BooksService {

    private final BooksRepository booksRepository;
    private final AuthorRepository authorRepository;

    public BooksService(BooksRepository booksRepository, AuthorRepository authorRepository) {
        this.booksRepository = booksRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> getAll() {
        log.info("find all books: books={}", booksRepository.findAll());
        return booksRepository.findAll();
    }

    public List<Book> getSorted(String sortCriteria) {
        List<Book> sortedBooks = switch(sortCriteria) {
            case "author" -> booksRepository.findAllByOrderByAuthorLastNameAsc();
            case "title" -> booksRepository.findAllByOrderByTitleAsc();

            default -> throw new IllegalStateException("Unexpected value: " + sortCriteria);
        };
        return sortedBooks;
    }

    private String getAuthorById(int authorId) {
        Author author = authorRepository.findById(authorId).orElse(null);
        return author != null ? author.getLastName() : "";
    }
}
