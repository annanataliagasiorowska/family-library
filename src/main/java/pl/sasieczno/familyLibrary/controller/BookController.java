package pl.sasieczno.familyLibrary.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pl.sasieczno.familyLibrary.dto.BookDto;
import pl.sasieczno.familyLibrary.dto.BookSummaryDto;
import pl.sasieczno.familyLibrary.model.Owner;
import pl.sasieczno.familyLibrary.service.BookService;

import java.util.List;

@RestController
@Slf4j
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
    public ResponseEntity<List<BookSummaryDto>> getByPhrase(@RequestParam(value = "phrase", required = false) String phrase) {
        return new ResponseEntity<>(booksService.searchByPhraseInTitle(phrase), HttpStatus.OK);
    }

    @PostMapping("/books")
    public void addBook(@RequestBody BookDto book, @AuthenticationPrincipal Owner owner) {
        Integer ownerId = owner.getId();
        log.debug("Find: ownerId={}", ownerId);
        booksService.addBook(book, ownerId);
    }

    @PutMapping("/books/{book_id}")
    public void updateBookData(@PathVariable("book_id") Integer bookId, @AuthenticationPrincipal Owner owner) {
        booksService.updateBook(bookId);
    }







}
