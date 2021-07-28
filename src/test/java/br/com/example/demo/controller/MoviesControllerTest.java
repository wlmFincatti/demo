package br.com.example.demo.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// TODO: falar com o will
class MoviesControllerTest {

    private String BASE_URL_PATH = "/demo/v1";
//    @LocalServerPort
//    private Integer port;

    @Test
    void shouldReturnMovieDetailsSchemaWithStatusCode200WhenCalledWithId497698() {
        given()
            .basePath(BASE_URL_PATH)
            .port(8080)
        .when()
            .get("/movie/497698")
        .then()
            .statusCode(200)
            .body("id", is(497698));
    }

    @Test
    void shouldReturnMovieDetailsWithStatus404WhenCalledWithAnInvalidId49769800() {
        given()
            .basePath(BASE_URL_PATH)
            .port(8080)
        .when()
            .get("/movie/49769800")
        .then()
            .statusCode(404)
            .body(containsString("title"),
                containsString("status"),
                containsString("details"))
            .body("status", is("NOT_FOUND"));
    }
}
