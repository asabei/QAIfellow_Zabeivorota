package TestClasses;

import hooks.WebHooks;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ApiReqSteps;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReqTest extends WebHooks{
    @Test
    @DisplayName("Test api reqres")
    public void checkResponseTest() throws IOException {

        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/data.json"))));
        body.put("name", "Tomato");
        body.put("job", "Eat maket");
        new ApiReqSteps()
                .apiReq("https://reqres.in", "/api/users", body.toString(), 201);
    }
}
