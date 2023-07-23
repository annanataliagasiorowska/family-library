package pl.sasieczno.familyLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sasieczno.familyLibrary.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByOrderByAuthorLastNameAsc();
    List<Book> findAllByOrderByTitleAsc();
    List<Book> findByTitleContainingIgnoreCase(String phrase);

}
