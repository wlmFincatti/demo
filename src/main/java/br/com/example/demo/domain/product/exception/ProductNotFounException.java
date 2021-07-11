package br.com.example.demo.domain.product.exception;

public class ProductNotFounException extends RuntimeException {
    public ProductNotFounException() {
        super();
    }

    public ProductNotFounException(String property, String value) {
        super(String.format("product not found with %s %s", property, value));
    }

    public ProductNotFounException(String message, Throwable cause) {
        super(message, cause);
    }

}
