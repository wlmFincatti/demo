package br.com.example.demo.entrypoint.rest;

import br.com.example.demo.adapter.MovieAdapter;
import br.com.example.demo.entrypoint.rest.dto.MovieDetailsDto;
import br.com.example.demo.entrypoint.rest.dto.MovieDto;
import br.com.example.demo.entrypoint.rest.routes.ApiRoutes;
import br.com.example.demo.usecase.GetMovieDetails;
import br.com.example.demo.usecase.GetPopularMovies;
import br.com.example.demo.usecase.GetTopRatedMovies;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = ApiRoutes.BASE_URL_MOVIE)
@RequiredArgsConstructor
public class MovieControllerImpl implements MovieController {
    private final GetPopularMovies getPopularMovies;
    private final GetTopRatedMovies getTopRatedMovies;
    private final GetMovieDetails getMovieDetails;

    @Override
    public List<MovieDto> getPopularMovies(Integer page) {
        return MovieAdapter.convertToDto(getPopularMovies.execute(page));
    }

    @Override
    public List<MovieDto> getTopRatedMovies(Integer page) {
        return MovieAdapter.convertToDto(getTopRatedMovies.execute(page));
    }

    @Override
    public MovieDetailsDto getMovieDetails(Long id) {
        return getMovieDetails.execute(id);
    }
}
