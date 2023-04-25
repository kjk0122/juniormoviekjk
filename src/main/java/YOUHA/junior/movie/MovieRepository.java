package YOUHA.junior.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByOrderById();
    Optional<Movie> findByTitle(String title);
    @Override
    void deleteById(Long aLong);

}
