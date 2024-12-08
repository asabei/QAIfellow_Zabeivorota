package hooks;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.util.Arrays;
import java.util.List;

public class WebHooks {
    @BeforeEach
    public void beforeEach(){
        Filter requestLogFilter = new RequestLoggingFilter(LogDetail.ALL);
        Filter responseLogFilter = new ResponseLoggingFilter(LogDetail.ALL);
        List<Filter> filters = Arrays.asList(requestLogFilter, responseLogFilter);
        RestAssured.filters(filters);
    }

    @AfterEach
    public void afterEach(){
        RestAssured.filters();
    }
}

