package br.com.example.demo.entrypoint.rest.routes;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProductRoutes {

    public static final String BASE_PATH_PRODUCT = "/api/v1/products";
    public static final String BY_ID = "/{id}";

}
