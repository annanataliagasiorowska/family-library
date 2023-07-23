package pl.sasieczno.familyLibrary.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sasieczno.familyLibrary.model.Book;
import pl.sasieczno.familyLibrary.service.BookService;
import pl.sasieczno.familyLibrary.BookSummaryDto;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    private final BookService booksService;

    public BookController(BookService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookSummaryDto>> getSorted(@RequestParam(value = "sort", defaultValue = "title") String sortCriteria) {
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
