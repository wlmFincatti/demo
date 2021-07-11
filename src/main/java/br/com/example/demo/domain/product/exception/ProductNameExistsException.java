package br.com.example.demo.domain.product.exception;

public class ProductNameExistsException extends RuntimeException {
    public ProductNameExistsException() {
        super();
    }

    public ProductNameExistsException(String message) {
        super(String.format("product with name &s exists", message));
    }

    public ProductNameExistsException(String message, Throwable cause) {
        super(message, cause);
    }

}
