package br.com.example.demo.adapter;

import br.com.example.demo.domain.TVShows;
import br.com.example.demo.entrypoint.rest.dto.*;
import br.com.example.demo.external.gateway.dto.TVShowsDetails;
import br.com.example.demo.external.gateway.dto.TVShowsResponse;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
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

    public static TVShowsDetailsDto convertToDetailsDto(TVShowsDetails tvShowsDetails) {
        var dto = TVShowsDetailsDto.builder().build();
        BeanUtils.copyProperties(tvShowsDetails, dto);
        setLastEpisodeToAir(tvShowsDetails, dto);
        setSeasons(tvShowsDetails, dto);
        setSpokenLanguages(tvShowsDetails, dto);
        return dto;
    }

    private static void setSpokenLanguages(TVShowsDetails tvShowsDetails, TVShowsDetailsDto dto) {
        List<SpokenLanguagesDto> spokenLanguages = new ArrayList<>();
        tvShowsDetails.getSpokenLanguages().forEach(sLR -> {
            var sLD = SpokenLanguagesDto.builder().build();
            BeanUtils.copyProperties(sLR, sLD);
            spokenLanguages.add(sLD);
        });
        dto.setSpokenLanguages(spokenLanguages);
    }

    private static void setSeasons(TVShowsDetails tvShowsDetails, TVShowsDetailsDto dto) {
        List<SeasonsDto> seasons = new ArrayList<>();
        tvShowsDetails.getSeasons().forEach(sR -> {
            var sD = SeasonsDto.builder().build();
            BeanUtils.copyProperties(sR, sD);
            seasons.add(sD);
        });
        dto.setSeasons(seasons);
    }

    private static void setLastEpisodeToAir(TVShowsDetails tvShowsDetails, TVShowsDetailsDto dto) {
        var lETAD = LastEpisodeToAirDto.builder().build();
        BeanUtils.copyProperties(tvShowsDetails.getLastEpisodeToAir(), lETAD);
        dto.setLastEpisodeToAir(lETAD);
    }
}
