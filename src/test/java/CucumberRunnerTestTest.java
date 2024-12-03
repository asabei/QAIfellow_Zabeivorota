
import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;



import static io.cucumber.junit.platform.engine.Constants.FEATURES_PROPERTY_NAME;

@Suite//as suit on the JUnitPlatform
@IncludeEngines("cucumber")//which engine will be used when running on junitplatform
@SelectClasspathResource("src/test/java/steps")//steps location
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/features")//feature location
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@test")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = Constants.FILTER_NAME_PROPERTY_NAME, value = ".*тест")
public class CucumberRunnerTestTest {

}