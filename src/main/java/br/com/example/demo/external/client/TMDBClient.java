package br.com.example.demo.external.client;

import br.com.example.demo.external.gateway.dto.TMDBGatewayMoviesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "tmdb client", url = "${tmdb.base.url}")
public interface TMDBClient {

    @GetMapping(value = "/movie/popular", consumes = MediaType.APPLICATION_ATOM_XML_VALUE)
    TMDBGatewayMoviesResponse getPopularMovies(@SpringQueryMap TMDBClientParams params);
}
