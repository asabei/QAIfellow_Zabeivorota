package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"classpath:steps", "classpath:hooks"},
        plugin = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
)
public class TestClass {

}