package pl.sasieczno.familyLibrary.model;

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
    private Integer releaseYear;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;
    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;



}
