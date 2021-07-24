package br.com.example.demo.usecase;

import br.com.example.demo.entrypoint.rest.dto.MovieDetailsDto;

public interface GetMovieDetails {
    MovieDetailsDto execute(Long id);
}
