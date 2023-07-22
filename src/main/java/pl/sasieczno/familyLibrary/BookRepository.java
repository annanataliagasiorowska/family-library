package pl.sasieczno.familyLibrary;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByOrderByAuthorLastNameAsc();
    List<Book> findAllByOrderByTitleAsc();
    List<Book> findByTitleContainingIgnoreCase(String phrase);

}
