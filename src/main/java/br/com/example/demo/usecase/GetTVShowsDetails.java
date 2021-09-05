package br.com.example.demo.usecase;

import br.com.example.demo.entrypoint.rest.dto.TVShowsDetailsDto;

public interface GetTVShowsDetails {
    TVShowsDetailsDto execute(Long id);
}
