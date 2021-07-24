package br.com.example.demo.usecase.impl;

import br.com.example.demo.adapter.MovieAdapter;
import br.com.example.demo.config.exceptions.ApiException;
import br.com.example.demo.config.exceptions.MovieNotFoundException;
import br.com.example.demo.entrypoint.rest.dto.MovieDetailsDto;
import br.com.example.demo.external.gateway.TMDBGateway;
import br.com.example.demo.usecase.GetMovieDetails;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMovieDetailsImpl implements GetMovieDetails {
    private final TMDBGateway tmdbGateway;

    @Override
    public MovieDetailsDto execute(Long id) {
        try {
            return MovieAdapter.convertToDetailsDto(tmdbGateway.getMovieDetails(id));
        } catch (FeignException e) {
            if (e.status() == 404) {
                throw new MovieNotFoundException();
            } else {
                throw new ApiException(e);
            }
        }
    }
}
