package YOUHA.junior.movie;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MovieResponseDto {
    private Long id;
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

    public MovieResponseDto(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.releaseYear = movie.getReleaseYear();
        this.genre = movie.getGenre();
        this.director = movie.getDirector();
        this.actors = movie.getActors();
        this.rating = movie.getRating();
        this.runtime = movie.getRuntime();
        this.synopsis = movie.getSynopsis();
        this.ageRating = movie.getAgeRating();
        this.dubbingLanguages = movie.getDubbingLanguages();
        this.subtitleLanguages = movie.getSubtitleLanguages();
    }

}

