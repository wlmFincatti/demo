package br.com.example.demo.adapter;

import br.com.example.demo.domain.TVShows;
import br.com.example.demo.entrypoint.rest.dto.TVShowsDto;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class TVShowsAdapter {

    public static TVShows toDomain(TVShowsResponse response) {
        var tv = TVShows.builder().build();
        BeanUtils.copyProperties(response, tv);
        return tv;
    }

    public static List<TVShows> convertToDomain(List<TVShowsResponse> responses) {
        return responses.stream()
            .map(TVShowsAdapter::toDomain)
            .collect(Collectors.toList());
    }

    public static TVShowsDto toDto(TVShows tvShow) {
        var dto = TVShowsDto.builder().build();
        BeanUtils.copyProperties(tvShow, dto);
        return dto;
    }

    public static List<TVShowsDto> convertToDto(List<TVShows> tvShows) {
        return tvShows.stream()
            .map(TVShowsAdapter::toDto)
            .collect(Collectors.toList());
    }
}
