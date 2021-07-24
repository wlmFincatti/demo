package br.com.example.demo.external.gateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpokenLanguagesResponse {
    @JsonProperty("english_name")
    private String englishName;
    private String ISO6391;
    private String name;
}
