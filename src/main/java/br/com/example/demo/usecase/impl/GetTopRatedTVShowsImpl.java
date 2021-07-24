package br.com.example.demo.usecase.impl;

import br.com.example.demo.adapter.TVShowsAdapter;
import br.com.example.demo.domain.TVShows;
import br.com.example.demo.external.gateway.TMDBGateway;
import br.com.example.demo.usecase.GetTopRatedTVShows;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTopRatedTVShowsImpl implements GetTopRatedTVShows {

    private final TMDBGateway gateway;

    @Override
    public List<TVShows> execute(Integer page) {
        return TVShowsAdapter.convertToDomain(gateway.getTopRatedTVShows(page));
    }
}
