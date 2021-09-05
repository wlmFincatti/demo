package br.com.example.demo.entrypoint.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpokenLanguagesDto {
    private String englishName;
    private String ISO6391;
    private String name;
}
