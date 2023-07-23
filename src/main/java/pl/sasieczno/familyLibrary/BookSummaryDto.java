package pl.sasieczno.familyLibrary;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookSummaryDto {
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private Integer releaseYear;

}
