package br.com.example.demo.external.gateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class TVShowsResponse extends Content {
    @JsonProperty("first_air_date")
    private LocalDate firstAirDate;
    private String name;
    @JsonProperty("origin_country")
    private List<String> originCountry;
    @JsonProperty("original_name")
    private String originalName;
}
