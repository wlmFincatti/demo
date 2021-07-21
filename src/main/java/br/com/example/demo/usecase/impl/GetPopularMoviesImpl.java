package br.com.example.demo.usecase.impl;

import br.com.example.demo.adapter.MovieAdapter;
import br.com.example.demo.domain.Movie;
import br.com.example.demo.external.gateway.TMDBGateway;
import br.com.example.demo.usecase.GetPopularMovies;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPopularMoviesImpl implements GetPopularMovies {

    private final TMDBGateway tmdbGateway;

    @Override
    public List<Movie> execute(Integer page) {
        final var _page = page == null ? 1 : page;
        return MovieAdapter.convertToDomain(tmdbGateway.getPopularMovies(_page));
    }
}
