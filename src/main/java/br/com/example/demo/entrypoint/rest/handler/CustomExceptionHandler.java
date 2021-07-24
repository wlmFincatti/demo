package br.com.example.demo.entrypoint.rest.handler;

import br.com.example.demo.config.exceptions.ApiException;
import br.com.example.demo.config.exceptions.MovieNotFoundException;
import br.com.example.demo.entrypoint.rest.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(ApiException ex) {
        ErrorResponse error = ErrorResponse
            .builder()
            .title(ex.getTitle())
            .detail(ex.getMessage())
            .status(HttpStatus.NOT_FOUND)
            .build();
        return ResponseEntity.status(404).body(error);
    }

}
