package br.com.example.demo.entrypoint.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ErrorResponse {

    @Schema(name = "title", description = "title of message error", example = "Movie not found")
    private String title;
    @Schema(name = "details", description = "details of message error", example = "Movie id is not valid")
    private String details;
    @Schema(name = "status", description = "Status code and description", example = "400 BAD_REQUEST")
    private HttpStatus status;

}
