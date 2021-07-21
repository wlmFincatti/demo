package br.com.example.demo.entrypoint.rest;

import br.com.example.demo.entrypoint.rest.dto.MovieDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MovieController {
    @Operation(summary = "Get popular movies",
        description = "Endpoint to retrieve all movies in a page",
        parameters = {
            @Parameter(name = "page",
                description = "the number of the page to read the movies from",
                in = ParameterIn.QUERY)
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Movies were retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        })
    @GetMapping
    List<MovieDto> getPopularMovies(@RequestParam(required = false, defaultValue = "1") Integer page);
}
