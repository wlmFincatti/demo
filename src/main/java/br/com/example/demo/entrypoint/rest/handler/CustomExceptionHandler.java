package br.com.example.demo.entrypoint.rest.handler;

import br.com.example.demo.domain.product.exception.ProductNameExistsException;
import br.com.example.demo.domain.product.exception.ProductNotFoundException;
import br.com.example.demo.entrypoint.rest.dto.ErrorResponse;
import br.com.example.demo.entrypoint.rest.dto.ErrorWrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomExceptionHandler {

    public static final String FIELDS_INVALIDS = "Fields invalids";
    public static final String PRODUCT_NOT_FOUND = "Product Not found";

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException ex) {
        ErrorResponse error = ErrorResponse
            .builder()
            .title(PRODUCT_NOT_FOUND)
            .detail(ex.getMessage())
            .status(HttpStatus.NOT_FOUND)
            .build();
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(ProductNameExistsException.class)
    public ResponseEntity<ErrorResponse> handleProductExists(ProductNameExistsException ex) {
        ErrorResponse error = ErrorResponse
            .builder()
            .title(FIELDS_INVALIDS)
            .detail(ex.getMessage())
            .status(HttpStatus.UNPROCESSABLE_ENTITY)
            .build();
        return ResponseEntity.status(422).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorWrapperResponse> handleProductExists(MethodArgumentNotValidException ex) {

        Set<ErrorResponse> erros = ex
            .getAllErrors()
            .stream()
            .map(e -> ErrorResponse
                .builder()
                .title(FIELDS_INVALIDS)
                .detail(e.getDefaultMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build())
            .collect(Collectors.toSet());

        return ResponseEntity
            .status(400)
            .body(ErrorWrapperResponse
                .builder()
                .dateError(LocalDateTime.now())
                .total(erros.size())
                .errorResponse(erros)
                .build());
    }

}
