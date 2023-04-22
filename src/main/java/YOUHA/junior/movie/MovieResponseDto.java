package YOUHA.junior.movie;

import lombok.Getter;

@Getter
public class MovieResponseDto {
    private Long id;
    private String title;
    public MovieResponseDto(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
    }
}
