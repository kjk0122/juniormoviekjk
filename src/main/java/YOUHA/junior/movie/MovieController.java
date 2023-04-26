package YOUHA.junior.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @ApiOperation(value = "영화 정보 가져오기")
    @GetMapping("")
    public List<MovieResponseDto> getMovies(@RequestParam(required = false) String title,
                                            @RequestParam(required = false) Short releaseYear,
                                            @RequestParam(required = false) String genre,
                                            @RequestParam(required = false) String director,
                                            @RequestParam(required = false) List<String> actors,
                                            @RequestParam(required = false) Float rating,
                                            @RequestParam(required = false) Short runtime,
                                            @RequestParam(required = false) String synopsis,
                                            @RequestParam(required = false) Short ageRating,
                                            @RequestParam(required = false) List<String> dubbingLanguages,
                                            @RequestParam(required = false) List<String> subtitleLanguages) {
        // 검색어를 포함한 영화 정보 가져오기
        return movieService.getMovies(title, releaseYear, genre, director, actors, rating, runtime, synopsis, ageRating, dubbingLanguages, subtitleLanguages);
    }

    @ApiOperation(value = "단일 영화 정보 가져오기")
    @GetMapping("/{movie_id}")
    public MovieResponseDto getBoard(@PathVariable Long movie_id) {
        MovieResponseDto movieResponseDto = movieService.getMovie(movie_id);
        return movieResponseDto;
    }

    @ApiOperation(value = "영화 정보 올리기")
    @PostMapping("")
    public ResponseEntity<MovieResponseDto> uploadMovie(@Valid @RequestBody MovieRequestDto movieRequestDto,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        MovieResponseDto movieResponseDto = movieService.uploadMovie(movieRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieResponseDto);
    }

    @ApiOperation(value = "영화 정보 수정하기")
    @PutMapping("/{movie_id}")
    public ResponseEntity<Void> updateMovie(@PathVariable Long movie_id, @RequestBody MovieRequestDto movieRequestDto) {
        movieService.updateMovie(movie_id, movieRequestDto);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "영화 정보 삭제")
    @DeleteMapping("/{movie_id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long movie_id) {
        movieService.deleteMovie(movie_id);
        return ResponseEntity.noContent().build();
    }
}
