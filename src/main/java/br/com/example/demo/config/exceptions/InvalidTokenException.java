package br.com.example.demo.config.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidTokenException extends ApiException {

    private static final String title = "Invalid token";
    private static final String message = "Token could not be read";

    public InvalidTokenException() {
        super(message, title, HttpStatus.UNAUTHORIZED);
    }
}
