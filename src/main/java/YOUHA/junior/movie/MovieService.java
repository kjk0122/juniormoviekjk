package YOUHA.junior.movie;

import YOUHA.junior.exception.RestApiExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    public List<MovieResponseDto> getMovies(String title, Short releaseYear, String genre, String director,
                                            List<String> actors, Float rating, Short runtime, String synopsis,
                                            Short ageRating, List<String> dubbingLanguages, List<String> subtitleLanguages) {
        return movieRepository.findByConditions(
                title, releaseYear, genre, director, actors, rating, runtime, synopsis, ageRating, dubbingLanguages, subtitleLanguages
        ).stream().map(MovieResponseDto::new).collect(Collectors.toList());
    }
    public MovieResponseDto getMovie(Long movie_id) throws NoSuchElementException{
        Movie movie = movieRepository.findById(movie_id).orElseThrow(
                () -> new NoSuchElementException("존재하지 않는 내용입니다")
        );
        return new MovieResponseDto(movie);
    }
    @Transactional
    public MovieResponseDto uploadMovie(MovieRequestDto movieRequestDto) {
        Optional<Movie> found = movieRepository.findByTitle(movieRequestDto.getTitle());
        if (found.isPresent()) {
            throw new RestApiExceptionHandler.ConflictException("이미 입력된 제목입니다.");
        }
        Movie movie =new Movie(movieRequestDto);
        movieRepository.save(movie);
        return new MovieResponseDto(movie);
    }
    @Transactional
    public MovieResponseDto updateMovie(Long movie_id, MovieRequestDto movieRequestDto) {
        Movie movie = movieRepository.findById(movie_id).orElseThrow(
                () -> new NoSuchElementException("존재하지 않는 내용입니다"));
        movie.update(movieRequestDto);
        Movie updatedMovie = movieRepository.save(movie);
        return new MovieResponseDto(updatedMovie);
    }
    @Transactional
    public void deleteMovie(Long movie_id) {
        try {
            movieRepository.deleteById(movie_id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchElementException("해당 데이터는 존재하지 않습니다.");
        }
    }

}
