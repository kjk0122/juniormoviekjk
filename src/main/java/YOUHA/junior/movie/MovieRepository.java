package YOUHA.junior.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByOrderById();
    Optional<Movie> findByTitle(String title);
    @Query("SELECT DISTINCT m FROM Movie m LEFT JOIN m.actors actors LEFT JOIN m.dubbingLanguages dubbingLangs LEFT JOIN m.subtitleLanguages subtitleLangs WHERE " +
            "(:title IS NULL OR m.title LIKE %:title%) AND " +
            "(:releaseYear IS NULL OR m.releaseYear = :releaseYear) AND " +
            "(:genre IS NULL OR m.genre LIKE %:genre%) AND " +
            "(:director IS NULL OR m.director LIKE %:director%) AND " +
            "(:actors IS NULL OR actors IN :actors) AND " +
            "(:rating IS NULL OR m.rating = :rating) AND " +
            "(:runtime IS NULL OR m.runtime = :runtime) AND " +
            "(:synopsis IS NULL OR m.synopsis LIKE %:synopsis%) AND " +
            "(:ageRating IS NULL OR m.ageRating = :ageRating) AND " +
            "(:dubbingLanguages IS NULL OR dubbingLangs IN :dubbingLanguages) AND " +
            "(:subtitleLanguages IS NULL OR subtitleLangs IN :subtitleLanguages)"  //이렇게 긴 쿼리문 나누기...어쩐다...
    )
    List<Movie> findByConditions(
            @Param("title") String title,
            @Param("releaseYear") Short releaseYear,
            @Param("genre") String genre,
            @Param("director") String director,
            @Param("actors") List<String> actors,
            @Param("rating") Float rating,
            @Param("runtime") Short runtime,
            @Param("synopsis") String synopsis,
            @Param("ageRating") Short ageRating,
            @Param("dubbingLanguages") List<String> dubbingLanguages,
            @Param("subtitleLanguages") List<String> subtitleLanguages
    );

    @Override
    void deleteById(Long aLong);

}
