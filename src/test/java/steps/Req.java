package steps;

import io.cucumber.java.ru.И;
import org.json.JSONObject;
import pages.ApiReq;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Req {
    @И("Проверка тест")
    public void checkResponseTest() throws IOException {

        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/data.json"))));
        body.put("name", "Tomato");
        body.put("job", "Eat maket");
        new ApiReq()
                .apiReq("https://reqres.in", "/api/users", body.toString(), 201);
    }
}
