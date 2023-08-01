package pl.sasieczno.familyLibrary.dto;

import lombok.Data;

@Data
public class BookDto {
    private Integer id;
    private String title;
    private Double rating;
    private Double internalRating;
    private Integer releaseYear;
    private Integer authorId;
    private Integer genreId;
    private Integer placeId;

}
