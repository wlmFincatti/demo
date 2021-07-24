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
public class CreatedByResponse {
    private Long id;
    @JsonProperty("credit_id")
    private String creditId;
    private String name;
    private String gender;
    @JsonProperty("profile_path")
    private String profilePath;
}
