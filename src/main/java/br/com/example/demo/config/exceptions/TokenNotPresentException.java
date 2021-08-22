package br.com.example.demo.config.exceptions;

import org.springframework.http.HttpStatus;

public class TokenNotPresentException extends ApiException {
    private static final String title = "Token not found";
    private static final String message = "Token was not sent in request";

    public TokenNotPresentException() {
        super(message, title, HttpStatus.NOT_ACCEPTABLE);
    }
}
