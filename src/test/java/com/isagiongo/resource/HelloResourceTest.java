package com.isagiongo.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class HelloResourceTest {

    @Test
    public void testHelloWorldEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(HttpStatus.SC_OK)
             .body(is("hello world"));
    }

    @Test
    public void shouldReturnHelloQuarkusEndpointQuarkus() {
        given()
                .when().get("/hello/quarkus")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(is("hello quarkus"));
    }

}