package YOUHA.junior.movie;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private short releaseYear;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String director;

    @ElementCollection
    private List<String> actors;

    @Column(nullable = false)
    private float rating;

    @Column(nullable = false)
    private short runtime;

    @Column(nullable = false)
    private String synopsis;

    @Column(nullable = false)
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
        this.title = movieRequestDto.getTitle();
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