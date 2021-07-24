package br.com.example.demo.config.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MovieNotFoundException extends ApiException {
    private static final String title = "Movie not found";

    public MovieNotFoundException() {
        super(title, "Movie id is not valid", HttpStatus.NOT_FOUND);
    }
}
