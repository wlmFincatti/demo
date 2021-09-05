package br.com.example.demo.usecase.impl;

import br.com.example.demo.adapter.MovieAdapter;
import br.com.example.demo.domain.Movie;
import br.com.example.demo.external.gateway.TMDBGateway;
import br.com.example.demo.usecase.GetTopRatedMovies;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTopRatedMoviesImpl implements GetTopRatedMovies {
    private final TMDBGateway tmdbGateway;

    @Override
    public List<Movie> execute(Integer page) {
        return MovieAdapter.convertToDomain(tmdbGateway.getTopRatedMovies(page));
    }
}
