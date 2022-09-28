package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import ch.zli.m223.model.User;
import static io.restassured.RestAssured.given;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

@QuarkusTest
public class UserRessourceTest {
    // Good Case
    @Test
    public void testGetAll() throws IOException, InterruptedException {
        String token = getAdminToken();
        given()
        .header("Authorization", "Bearer " + token)
        .when().get("/api/users/getAll")
        .then()
            .statusCode(200);
    }
    // Bad Case
    @Test
    public void testDeleteEndpoint() throws IOException, InterruptedException {
       String token = getUserToken();
        RestAssured.
            given()
                .header("Authorization", "Bearer " + token)
                .when().delete("/api/users/delete/1")
                .then()
                    .assertThat()
                    .statusCode(403);
   
    }
    // This method will get the JWT token for the Testcases
    private String getAdminToken() throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/auth/login/jon@gmail.com/password"))
            .GET()
            .build();
       
        // use the client to send the request
        var response = client.send(request, BodyHandlers.ofString());
        String token = response.body().toString();
        return token;
    }
    private String getUserToken() throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/auth/login/test@test/test"))
            .GET()
            .build();
       
        // use the client to send the request
        var response = client.send(request, BodyHandlers.ofString());
        String token = response.body().toString();
        return token;
    }
}
