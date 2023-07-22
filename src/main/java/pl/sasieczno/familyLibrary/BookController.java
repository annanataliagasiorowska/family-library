package pl.sasieczno.familyLibrary;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService booksService;

    public BookController(BookService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getSorted(@RequestParam(value = "sort", defaultValue = "title") String sortCriteria) {
        return new ResponseEntity<>(booksService.getSorted(sortCriteria), HttpStatus.OK);
    }

    @GetMapping("/books/search")
    public ResponseEntity<List<Book>> getByPhrase(@RequestParam(value = "phrase", required = false) String phrase) {
        return new ResponseEntity<>(booksService.searchByPhraseInTitle(phrase), HttpStatus.OK);
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book) {
        booksService.addBook(book);
    }






}
