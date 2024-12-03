package hooks;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebHooks {
    @Before
    public void initBrowser() {
        Configuration.browser = Browsers.CHROME;
        Selenide.open("https://edujira.ifellow.ru/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
