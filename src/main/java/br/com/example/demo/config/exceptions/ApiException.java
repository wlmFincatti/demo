package br.com.example.demo.config.exceptions;

import feign.FeignException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {
    private String title;
    private HttpStatus httpStatus;

    protected ApiException(String message, String title, HttpStatus httpStatus) {
        super(message);
        this.title = title;
        this.httpStatus = httpStatus;
    }

    public ApiException(FeignException e) {
        super(e.getMessage());
        title = "API Error";
        httpStatus = HttpStatus.resolve(e.status());
    }
}
