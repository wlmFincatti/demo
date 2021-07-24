package br.com.example.demo.external.gateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductionCompaniesResponse {
    private Long id;
    @JsonProperty("logo_path")
    private String logoPath;
    private String name;
    @JsonProperty("origin_country")
    private String originCountry;
}
