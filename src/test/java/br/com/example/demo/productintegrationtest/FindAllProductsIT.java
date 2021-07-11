package br.com.example.demo.productintegrationtest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static io.restassured.RestAssured.given;

@ContextConfiguration()
@ActiveProfiles("it")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class FindAllProductsIT extends HookIT {


    @Test
    void shouldFindAllProducts() {
        given()
            .get()
            .then()
            .statusCode(200);
    }


}
