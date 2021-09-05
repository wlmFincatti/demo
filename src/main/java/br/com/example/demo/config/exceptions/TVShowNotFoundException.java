package br.com.example.demo.config.exceptions;

import org.springframework.http.HttpStatus;

public class TVShowNotFoundException extends ApiException {
    private static final String title = "TV Show not found.";
    private static final String msg = "TV Show id is not valid.";

    public TVShowNotFoundException() {
        super(msg, title, HttpStatus.NOT_FOUND);
    }
}
