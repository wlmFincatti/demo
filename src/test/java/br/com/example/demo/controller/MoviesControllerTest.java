package br.com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.is;

@SpringBootTest
class MoviesControllerTest {

    private StringBuilder BASE_URL_PATH = new StringBuilder("http://localhost:8080/demo/v1");

    @Test
    void shouldReturnMovieDetailsSchemaWithStatusCode200WhenCalledWithNoPageParameter() {
        get(BASE_URL_PATH.append("/movie/497698").toString())
            .then()
            .statusCode(200)
            .body("id", is(497698));
    }
}
