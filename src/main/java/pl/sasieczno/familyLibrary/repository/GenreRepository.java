package pl.sasieczno.familyLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sasieczno.familyLibrary.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
