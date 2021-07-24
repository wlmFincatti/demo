package br.com.example.demo.usecase.impl;

import br.com.example.demo.adapter.TVShowsAdapter;
import br.com.example.demo.config.exceptions.ApiException;
import br.com.example.demo.config.exceptions.TVShowNotFoundException;
import br.com.example.demo.entrypoint.rest.dto.TVShowsDetailsDto;
import br.com.example.demo.external.gateway.TMDBGateway;
import br.com.example.demo.usecase.GetTVShowsDetails;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTVShowsDetailsImpl implements GetTVShowsDetails {
    private final TMDBGateway tmdbGateway;

    @Override
    public TVShowsDetailsDto execute(Long id) {
        try {
            return TVShowsAdapter.convertToDetailsDto(tmdbGateway.getTVShowsDetails(id));
        } catch (FeignException e) {
            if (e.status() == 404) {
                throw new TVShowNotFoundException();
            }
            throw new ApiException(e);
        }
    }
}
