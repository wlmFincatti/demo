package br.com.example.demo.adapter;

import br.com.example.demo.domain.Movie;
import br.com.example.demo.entrypoint.rest.dto.MovieDto;
import br.com.example.demo.external.gateway.dto.MovieResponse;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class MovieAdapter {

    public static Movie toDomain(MovieResponse response) {
        var movie = Movie.builder().build();
        BeanUtils.copyProperties(response, movie);
        return movie;
    }

    public static List<Movie> convertToDomain(List<MovieResponse> responses) {
        return responses.stream()
            .map(MovieAdapter::toDomain)
            .collect(Collectors.toList());
    }
    
    public static MovieDto toDto(Movie movie) {
        var movieDto = MovieDto.builder().build();
        BeanUtils.copyProperties(movie, movieDto);
        return movieDto;
    }
    
    public static List<MovieDto> convertToDto(List<Movie> movies) {
        return movies.stream()
            .map(MovieAdapter::toDto)
            .collect(Collectors.toList());
    }
}
