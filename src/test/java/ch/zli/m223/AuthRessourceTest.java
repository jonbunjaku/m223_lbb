package ch.zli.m223;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.gradle.internal.impldep.javax.annotation.meta.When;
public class AuthRessourceTest {
    @Test
    public void testPostLogin() {
        given()
            .contentType(ContentType.JSON)
            .when()
                .post("http://localhost:8080/login?email=jon%gmail.com&password=password")
            .then()
            .statusCode(404);
    }

    @Test
    public void testPostRegister() {
        given()
        .body("{\"vorname\":\"jon\",\"nachname\":\"jon\", \"email\":\"jon@gmail.com\", \"passwort\":\"admin123\",\"isAdmin\":\"true\"}")
        .contentType(ContentType.JSON)
        .when()
            .post("http://localhost:8080/auth/register")
            .then()
            .statusCode(200);
    }
}
