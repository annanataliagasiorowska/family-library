package pl.sasieczno.familyLibrary;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@Table(name = "place")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany
    private List<Book> books;
    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;
}
