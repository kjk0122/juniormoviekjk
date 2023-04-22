package YOUHA.junior.movie;

import lombok.Getter;

import java.util.List;

@Getter
public class MovieRequestDto {
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
