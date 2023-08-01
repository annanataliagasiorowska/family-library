package pl.sasieczno.familyLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sasieczno.familyLibrary.model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
}
