package pl.sasieczno.familyLibrary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> getSorted(String sortCriteria) {
        List<Book> sortedBooks = switch(sortCriteria) {
            case "author" -> booksRepository.findAllByOrderByAuthorLastNameAsc();
            case "title" -> booksRepository.findAllByOrderByTitleAsc();

            default -> throw new IllegalStateException("Unexpected value: " + sortCriteria);
        };
        return sortedBooks;
    }

    public List<Book> searchByPhraseInTitle(String phrase) {
        return booksRepository.findByTitleContainingIgnoreCase(phrase);
    }


}
