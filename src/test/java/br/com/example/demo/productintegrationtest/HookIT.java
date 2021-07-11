package br.com.example.demo.productintegrationtest;

import br.com.example.demo.entrypoint.rest.routes.ProductRoutes;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class HookIT {

    @BeforeAll
    public static void setup() {
        RestAssured.basePath = ProductRoutes.BASE_PATH_PRODUCT;
        RestAssured.port = 8081;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

}
