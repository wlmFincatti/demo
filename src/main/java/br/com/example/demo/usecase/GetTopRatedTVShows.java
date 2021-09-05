package br.com.example.demo.usecase;

import br.com.example.demo.domain.TVShows;

import java.util.List;

public interface GetTopRatedTVShows {
    List<TVShows> execute(Integer page);
}
