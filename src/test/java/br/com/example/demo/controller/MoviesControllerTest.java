package br.com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = {
        "tmdb.api.key=1b7ac4704aa4d2e6bf887a3ec435f1c9"
    }
)
class MoviesControllerTest {

    private String BASE_URL_PATH = "/demo/v1";
    @LocalServerPort
    private Integer port;

    @Test
    void shouldReturnMovieDetailsSchemaWithStatusCode200WhenCalledWithId497698() {
        given()
            .basePath(BASE_URL_PATH)
            .port(port)
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
            .port(port)
        .when()
            .get("/movie/49769800")
        .then()
            .statusCode(404)
            .body(containsString("title"),
                containsString("status"),
                containsString("details"))
            .body("status", is("NOT_FOUND"));
    }

    @Test
    void shouldReturnPopularMoviesWith200StatusCodeWhenCalledWithoutPageParam() {
        given()
            .basePath(BASE_URL_PATH)
            .port(port)
        .when()
            .get("/movies/popular")
        .then()
            .statusCode(200);
    }

    @Test
    void shouldReturnPopularMoviesWith200StatusCodeWhenCalledWithAnIntegerPageParam() {
        given()
            .basePath(BASE_URL_PATH)
            .port(port)
        .when()
            .get("/movies/popular?page=2")
        .then()
            .statusCode(200);
    }

    @Test
    void shouldReturnTopRatedMoviesWith200StatusCodeWhenCalledWithoutPageParam() {
        given()
            .basePath(BASE_URL_PATH)
            .port(port)
        .when()
            .get("/tv/top_rated")
        .then()
            .statusCode(200);
    }

    @Test
    void shouldReturnTopRatedMoviesWith200StatusCodeWhenCalledWithAnIntegerPageParam() {
        given()
            .basePath(BASE_URL_PATH)
            .port(port)
        .when()
            .get("/tv/top_rated?page=2")
        .then()
            .statusCode(200);
    }
}
