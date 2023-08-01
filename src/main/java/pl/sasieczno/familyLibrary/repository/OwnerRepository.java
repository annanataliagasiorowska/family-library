package pl.sasieczno.familyLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sasieczno.familyLibrary.model.Library;
import pl.sasieczno.familyLibrary.model.Owner;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {

    Optional<Owner> findByEmail(String email);
    @Query("SELECT o.library FROM Owner o WHERE o.id = :ownerId")
    Library findLibraryByOwnerId(Integer ownerId);

}
