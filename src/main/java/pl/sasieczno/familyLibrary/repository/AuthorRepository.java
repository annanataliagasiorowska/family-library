package pl.sasieczno.familyLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sasieczno.familyLibrary.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
