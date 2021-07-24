package br.com.example.demo.entrypoint.rest;

import br.com.example.demo.adapter.TVShowsAdapter;
import br.com.example.demo.entrypoint.rest.dto.TVShowsDto;
import br.com.example.demo.entrypoint.rest.routes.ApiRoutes;
import br.com.example.demo.usecase.GetPopularTVShows;
import br.com.example.demo.usecase.GetTopRatedTVShows;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = ApiRoutes.BASE_URL_TV)
@RequiredArgsConstructor
public class TVControllerImpl implements TVController {
    private final GetTopRatedTVShows getTopRatedTVShows;
    private final GetPopularTVShows getPopularTVShows;

    @Override
    public List<TVShowsDto> getPopularTVShows(Integer page) {
        return TVShowsAdapter.convertToDto(getPopularTVShows.execute(page));
    }

    @Override
    public List<TVShowsDto> getTopRatedTVShows(Integer page) {
        return TVShowsAdapter.convertToDto(getTopRatedTVShows.execute(page));
    }
}
