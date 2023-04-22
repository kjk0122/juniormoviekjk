package YOUHA.junior.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional
    public MovieResponseDto uploadMovie(MovieRequestDto movieRequestDto, HttpServletRequest request) {
        Movie movie =new Movie(movieRequestDto);
        movieRepository.save(movie);
        return new MovieResponseDto(movie);
    }


    @Transactional(readOnly = true)
    public List<MovieResponseDto> getMovies() {
        List<MovieResponseDto> list = new ArrayList<>();

        List<Movie> movieList;
        movieList = movieRepository.findAllByOrderById();

        for (Movie movie : movieList) {
            list.add(new MovieResponseDto(movie));
        }
        return list;
    }
}
