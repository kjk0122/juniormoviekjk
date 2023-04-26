package YOUHA.junior.movie;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequestDto {
    @NotBlank(message = "제목은 필수 입력 값입니다.")
    private String title;
    private short releaseYear;
    private String genre;
    private String director;
    private List<String> actors;
    private float rating;
    private short runtime;
    private String synopsis;
    private short ageRating;
    private List<String> dubbingLanguages;
    private List<String> subtitleLanguages;
}
