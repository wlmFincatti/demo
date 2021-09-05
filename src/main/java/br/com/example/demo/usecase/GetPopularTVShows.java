package br.com.example.demo.usecase;

import br.com.example.demo.domain.TVShows;

import java.util.List;

public interface GetPopularTVShows {
    List<TVShows> execute(Integer page);
}
