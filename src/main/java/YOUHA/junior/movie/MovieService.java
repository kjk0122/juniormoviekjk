package YOUHA.junior.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    public List<MovieResponseDto> getMovies() {
        List<MovieResponseDto> list = new ArrayList<>();

        List<Movie> movieList;
        movieList = movieRepository.findAllByOrderById();

        for (Movie movie : movieList) {
            list.add(new MovieResponseDto(movie));
        }
        return list;
    }

    public MovieResponseDto getMovie(Long movie_id) {
        Movie movie = movieRepository.findById(movie_id).orElseThrow(
                () -> new NoSuchElementException("존재하지 않는 내용입니다")
        );
        return new MovieResponseDto(movie);
    }
    @Transactional
    public MovieResponseDto uploadMovie(MovieRequestDto movieRequestDto) {
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
