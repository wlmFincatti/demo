package br.com.example.demo.config.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MovieNotFoundException extends ApiException {
    private static final String title = "Movie not found";
    private static final String msg = "Movie id is not valid";

    public MovieNotFoundException() {
        super(title, msg, HttpStatus.NOT_FOUND);
    }
}
