package pl.sasieczno.familyLibrary;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(nullable = true)
    private Double rating;
    @Column(nullable = true)
    private Double internalRating;
    @Enumerated(EnumType.STRING)
    private Position position;
    private Integer releaseYear;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


}
