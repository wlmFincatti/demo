package br.com.example.demo.external.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TMDBGatewayTVShowsResponse extends TMDBGatewayContentResponse {
    List<TVShowsResponse> results;
}
