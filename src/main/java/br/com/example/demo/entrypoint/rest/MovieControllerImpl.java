package br.com.example.demo.entrypoint.rest;

import br.com.example.demo.adapter.MovieAdapter;
import br.com.example.demo.entrypoint.rest.dto.MovieDto;
import br.com.example.demo.entrypoint.rest.routes.MovieRoutes;
import br.com.example.demo.usecase.GetPopularMovies;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = MovieRoutes.BASE_URL_MOVIE)
@RequiredArgsConstructor
public class MovieControllerImpl implements MovieController {
    private final GetPopularMovies getPopularMovies;

    @Override
    public List<MovieDto> getPopularMovies(Integer page) {
        return MovieAdapter.convertToDto(getPopularMovies.execute(page));
    }
}
