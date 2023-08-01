package pl.sasieczno.familyLibrary.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sasieczno.familyLibrary.model.Author;
import pl.sasieczno.familyLibrary.service.AuthorService;

@RestController
@RequestMapping("/api")
public class AuthorController {
    private final AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/authors")
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }
}
