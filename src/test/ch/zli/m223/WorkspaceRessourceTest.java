@QuarkusTest
public class WorkspaceRessourceTest {
    // Good Case
    @Test
    public void testGetAll() throws IOException, InterruptedException {
        String token = getToken();
        given()
        .header("Authorization", "Bearer " + token)
        .when().get("http://127.0.0.1:8080/workplaces/getAll")
        .then()
            .statusCode(200);
    }
    // Bad Case
    @Test
    public void testDeleteEndpoint() throws IOException, InterruptedException {
       String token = getToken();
        RestAssured.
            given()
                .header("Authorization", "Bearer " + token)
                .when().delete("http://127.0.0.1:8080/workplaces/delete/-5")
                .then()
                    .assertThat()
                    .statusCode(403);
   
    }
    // This method will get the JWT token for the Testcases
    private String getToken() throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://127.0.0.1:8080/auth/login/jon.bunjaku@coworking.ch/test"))
            .GET()
            .build();
       
        // use the client to send the request
        var response = client.send(request, BodyHandlers.ofString());
        String token = response.body().toString();
        return token;
    }
}
