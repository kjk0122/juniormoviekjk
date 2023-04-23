package YOUHA.junior.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {
private final MovieService movieService;
    @ApiOperation(value = "영화 정보 가져오기")
    @GetMapping("")
    public List<MovieResponseDto> getMovies(){
        // 응답 보내기
        return movieService.getMovies();
    }
    @ApiOperation(value = "단일 영화 정보 가져오기")
    @GetMapping("/{movie_id}")
    public MovieResponseDto getBoard(@PathVariable Long movie_id) {
        MovieResponseDto movieResponseDto = movieService.getMovie(movie_id);
        return movieResponseDto;
    }
    @ApiOperation(value = "영화 정보 올리기")
    @PostMapping("")
    public ResponseEntity<MovieResponseDto> uploadMovie(@RequestBody MovieRequestDto movieRequestDto){
        MovieResponseDto movieResponseDto = movieService.uploadMovie(movieRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(movieResponseDto);
    }
    @ApiOperation(value = "영화 정보 수정하기")
    @PutMapping("/{movie_id}")
    public ResponseEntity<MovieResponseDto> updateMovie(@PathVariable Long movie_id, @RequestBody MovieRequestDto movieRequestDto) {
        MovieResponseDto updatedMovie = movieService.updateMovie(movie_id, movieRequestDto);
        return ResponseEntity.ok(updatedMovie);
    }
}
