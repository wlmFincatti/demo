package br.com.example.demo.entrypoint.rest.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetailsDto extends MovieDto {
    private String homepage;
    private Long runtime;
    private List<SpokenLanguagesDto> spokenLanguages;
    private String status;
    private String tagline;
}
