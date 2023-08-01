package pl.sasieczno.familyLibrary.service;

import org.springframework.stereotype.Service;
import pl.sasieczno.familyLibrary.model.Author;
import pl.sasieczno.familyLibrary.repository.AuthorRepository;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author addAuthor(Author author) {
        Author newAuthor = new Author();
        newAuthor.setFirstName(author.getFirstName());
        newAuthor.setLastName(author.getLastName());
        newAuthor.setOrigin(author.getOrigin() != null ? author.getOrigin() : null);
        newAuthor.setBirthDate(author.getBirthDate() != null ? author.getBirthDate() : null);
        return authorRepository.save(newAuthor);
    }
}
