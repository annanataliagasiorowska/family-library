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

    public List<Book> getAll() {
        log.info("find all books: books={}", booksRepository.findAll());
        return booksRepository.findAll();
    }
}
