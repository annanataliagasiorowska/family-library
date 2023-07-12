package pl.sasieczno.familyLibrary;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BooksService booksService;

    public BookController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAll() {
        return new ResponseEntity<>(booksService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/books/search")
    public ResponseEntity<List<Book>> getByPhrase(@RequestParam(value = "phrase", required = false) String phrase) {
        return null;
    }

    @GetMapping("/books/sorted")
    public ResponseEntity<List<Book>> getSorted(@RequestParam(value = "sort") String sortCriteria) {
        return null;
    }




}
