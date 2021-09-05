package br.com.example.demo.entrypoint.rest;

import br.com.example.demo.entrypoint.rest.dto.TVShowsDetailsDto;
import br.com.example.demo.entrypoint.rest.dto.TVShowsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TVController {
    @Operation(summary = "Get popular tv shows",
        description = "Endpoint to retrieve all popular tv shows in a page",
        parameters = {
            @Parameter(name = "page",
                description = "the number of the page to read the movies from",
                in = ParameterIn.QUERY)
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "TV Shows were retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        })
    @GetMapping(path = "/tv/popular")
    List<TVShowsDto> getPopularTVShows(@RequestParam(required = false, defaultValue = "1") Integer page);

    @Operation(summary = "Get top rated tv shows",
        description = "Endpoint to retrieve all top rated tv shows in a page",
        parameters = {
            @Parameter(name = "page",
                description = "the number of the page to read the tv shows from",
                in = ParameterIn.QUERY)
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "TV Shows were retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        })
    @GetMapping(path = "/tv/top_rated")
    List<TVShowsDto> getTopRatedTVShows(@RequestParam(required = false, defaultValue = "1") Integer page);

    @Operation(summary = "Get tv show details",
        description = "Endpoint to retrieve tv shows details by id",
        parameters = {
            @Parameter(name = "id",
                description = "the id of the tv show",
                in = ParameterIn.PATH)
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "TV Shows were retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "TV Show was not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        })
    @GetMapping(path = "/tv/{id}")
    TVShowsDetailsDto getTVShowsDetails(@PathVariable Long id);
}
