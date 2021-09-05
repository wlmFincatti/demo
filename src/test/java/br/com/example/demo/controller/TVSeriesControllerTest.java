package br.com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = {"tmdb.api.key=1b7ac4704aa4d2e6bf887a3ec435f1c9"})
class TVSeriesControllerTest {
    @LocalServerPort
    private Integer port;
    private String BASE_URL_PATH = "/demo/v1";

    @Test
    void shouldReturnTvSerieDetailsWith200StatusCodeWhenCalledWithId84958() {
        given()
            .basePath(BASE_URL_PATH)
            .port(port)
        .when()
            .get("/tv/84958")
        .then()
            .statusCode(200)
            .body("id", is(84958));
    }

    @Test
    void shouldReturnTvSeriesDetailsWith404StatusCodeWhenCalledWithId8495800() {
        given()
            .basePath(BASE_URL_PATH)
            .port(port)
        .when()
            .get("/tv/8495800")
        .then()
            .statusCode(404)
            .body(containsString("title"),
                containsString("status"),
                containsString("details"))
            .body("status", is("NOT_FOUND"));
    }

    @Test
    void shouldReturnPopularTVShowsWith200StatusCodeWhenCalledWithoutPageParam() {
        given()
            .basePath(BASE_URL_PATH)
            .port(port)
        .when()
            .get("/tv/popular")
        .then()
            .statusCode(200);
    }

    @Test
    void shouldReturnPopularTVShowsWith200StatusCodeWhenCalledWithAnIntegerPageParam() {
        given()
            .basePath(BASE_URL_PATH)
            .port(port)
        .when()
            .get("/tv/popular?page=2")
        .then()
            .statusCode(200);
    }

    @Test
    void shouldReturnTopRatedTVShowsWith200StatusCodeWhenCalledWithoutPageParam() {
        given()
            .basePath(BASE_URL_PATH)
            .port(port)
        .when()
            .get("/tv/top_rated")
        .then()
            .statusCode(200);
    }

    @Test
    void shouldReturnTopRatedTVShowsWith200StatusCodeWhenCalledWithAnIntegerPageParam() {
        given()
            .basePath(BASE_URL_PATH)
            .port(port)
        .when()
            .get("/tv/top_rated?page=2")
        .then()
            .statusCode(200);
    }

}
