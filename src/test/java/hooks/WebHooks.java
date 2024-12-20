package hooks;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeEach;
import java.util.Arrays;
import java.util.List;
import io.qameta.allure.selenide.AllureSelenide;
import com.codeborne.selenide.logevents.SelenideLogger;

public class WebHooks {
    @Before
    public void beforeEach(){
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
        Filter requestLogFilter = new RequestLoggingFilter(LogDetail.ALL);
        Filter responseLogFilter = new ResponseLoggingFilter(LogDetail.ALL);

        List<Filter> filters = Arrays.asList(requestLogFilter, responseLogFilter);

        RestAssured.filters(filters);
    }
}