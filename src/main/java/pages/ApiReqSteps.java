package pages;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiReqSteps {
    public void apiReq(String baseUri, String postUri, String body, int statusCode){
        given()
                .header("Content-type", "application/json")
                .header("Charset", "UTF-8")
                .baseUri(baseUri)
                .body(body)
                .when()
                .post(postUri)
                .then()
                .statusCode(statusCode)
                .body("name", equalTo("Tomato"))
                .body("job", equalTo("Eat maket"));
    }
}
