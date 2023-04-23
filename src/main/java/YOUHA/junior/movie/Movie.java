package YOUHA.junior.movie;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private short releaseYear;
    private String genre;
    private String director;
    @ElementCollection
    private List<String> actors;
    private float rating;
    private short runtime;
    private String synopsis;
    private short ageRating;
    @ElementCollection
    private List<String> dubbingLanguages;
    @ElementCollection
    private List<String> subtitleLanguages;

    public Movie(MovieRequestDto movieRequestDto){
        this.title= movieRequestDto.getTitle();
        this.releaseYear = movieRequestDto.getReleaseYear();
        this.genre = movieRequestDto.getGenre();
        this.director = movieRequestDto.getDirector();
        this.actors = movieRequestDto.getActors();
        this.rating = movieRequestDto.getRating();
        this.runtime = movieRequestDto.getRuntime();
        this.synopsis = movieRequestDto.getSynopsis();
        this.ageRating = movieRequestDto.getAgeRating();
        this.dubbingLanguages = movieRequestDto.getDubbingLanguages();
        this.subtitleLanguages = movieRequestDto.getSubtitleLanguages();
    }
    public void update(MovieRequestDto movieRequestDto) {
        this.title= movieRequestDto.getTitle();
        this.releaseYear = movieRequestDto.getReleaseYear();
        this.genre = movieRequestDto.getGenre();
        this.director = movieRequestDto.getDirector();
        this.actors = movieRequestDto.getActors();
        this.rating = movieRequestDto.getRating();
        this.runtime = movieRequestDto.getRuntime();
        this.synopsis = movieRequestDto.getSynopsis();
        this.ageRating = movieRequestDto.getAgeRating();
        this.dubbingLanguages = movieRequestDto.getDubbingLanguages();
        this.subtitleLanguages = movieRequestDto.getSubtitleLanguages();
    }
}
