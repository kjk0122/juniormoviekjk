package YOUHA.junior.movie;

import YOUHA.junior.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByOrderById();
    @Override
    void deleteById(Long aLong);

}
