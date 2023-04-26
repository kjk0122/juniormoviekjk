import YOUHA.junior.movie.Movie;
import YOUHA.junior.movie.MovieRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    @Test
    @DisplayName("예시")
    void upMovie() {
        String title="화양연화";
        short releaseYear= 2000;
        String genre="로맨스";
        String director="왕가위";
        List<String> actors = Arrays.asList("양조위", "장만옥", "진만뢰");
        float rating = 9.5f;
        short runtime = 98;
        String synopsis="주씨(양조위)와 진부인(장만옥)은 바로 옆집에 사는 이웃이다. 두 사람은 각자 혼인을 한 상태이지만, 둘의 배우자가 서로 불륜 관계를 가진 채 외국으로 떠나버렸다. 그렇게 남겨진 두 사람은 서로를 위로하며 의지하게 되고, 서로에게 마음이 기울게 된다.";
        short ageRating =15;
        List<String> dubbingLanguages = Collections.singletonList("한국어");
        List<String> subtitleLanguages = Arrays.asList("한국어", "영어");

        MovieRequestDto movieRequestDto = new MovieRequestDto(title, releaseYear, genre, director, actors, rating,runtime, synopsis, ageRating, dubbingLanguages, subtitleLanguages);
        Movie movie = new Movie(movieRequestDto);

        assertNull(movie.getId());
        assertEquals(title, movie.getTitle());
        assertEquals(genre, movie.getGenre());
        assertEquals(director, movie.getDirector());
        assertEquals(releaseYear, movie.getReleaseYear());
    }
    @Test
    @DisplayName("예시")
    void seeMovie() {
        String title="화양연화";
        short releaseYear= 2000;
        String genre="로맨스";
        String director="왕가위";
        List<String> actors = Arrays.asList("양조위", "장만옥", "진만뢰");
        float rating = 9.5f;
        short runtime = 98;
        String synopsis="주씨(양조위)와 진부인(장만옥)은 바로 옆집에 사는 이웃이다. 두 사람은 각자 혼인을 한 상태이지만, 둘의 배우자가 서로 불륜 관계를 가진 채 외국으로 떠나버렸다. 그렇게 남겨진 두 사람은 서로를 위로하며 의지하게 되고, 서로에게 마음이 기울게 된다.";
        short ageRating =15;
        List<String> dubbingLanguages = Collections.singletonList("한국어");
        List<String> subtitleLanguages = Arrays.asList("한국어", "영어");

        MovieRequestDto movieRequestDto = new MovieRequestDto(title, releaseYear, genre, director, actors, rating,runtime, synopsis, ageRating, dubbingLanguages, subtitleLanguages);
        Movie movie = new Movie(movieRequestDto);

        assertNull(movie.getId());
        assertEquals(title, movie.getTitle());
        assertEquals(genre, movie.getGenre());
        assertEquals(director, movie.getDirector());
        assertEquals(releaseYear, movie.getReleaseYear());
    }
}