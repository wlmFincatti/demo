package br.com.example.demo.external.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TMDBClientParams {
    private String api_key;
    private Integer page;
}
