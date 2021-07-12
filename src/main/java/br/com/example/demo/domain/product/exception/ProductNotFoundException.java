package br.com.example.demo.domain.product.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super();
    }

    public ProductNotFoundException(String property, String value) {
        super(String.format("product not found with %s %s", property, value));
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
