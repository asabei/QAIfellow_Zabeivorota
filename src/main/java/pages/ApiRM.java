package pages;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.Assert;
import static io.restassured.RestAssured.given;

public class ApiRM {
    @Step("Проверка Рик и Морти")
    public void apiRm(String baseUri, int statusCode){
        Response mortyResponse = given()
                .baseUri(baseUri)
                .queryParam("name", "Morty Smith")
                .when()
                .get("/character")
                .then()
                .statusCode(statusCode)
                .extract().response();
        String lastEpisode = mortyResponse.jsonPath().getString("results[0].episode[-1]");

        Response lastEpisodeResponse = given()
                .get(lastEpisode)
                .then()
                .statusCode(statusCode)
                .extract().response();
        String lastPerson = lastEpisodeResponse.jsonPath().getString("characters[-1]");

        Response lastPersonResponse = given()
                .get(lastPerson)
                .then()
                .statusCode(statusCode)
                .extract().response();
        String lastPersonLocation = lastPersonResponse.jsonPath().getString("location.name");
        String lastPersonRace = lastPersonResponse.jsonPath().getString("species");

        Assert.assertNotEquals(lastPersonLocation, mortyResponse.jsonPath().getString("results[0].location.name"));
        Assert.assertEquals(lastPersonRace, mortyResponse.jsonPath().getString("results[0].species"));
    }
}
