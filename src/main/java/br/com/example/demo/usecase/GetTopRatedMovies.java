package br.com.example.demo.usecase;

import br.com.example.demo.domain.Movie;

import java.util.List;

public interface GetTopRatedMovies {
    List<Movie> execute(Integer page);
}
