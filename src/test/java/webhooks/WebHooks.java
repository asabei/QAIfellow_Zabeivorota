package webhooks;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import util.TestProperties;

public class WebHooks {
    @Step("open url")
    @BeforeEach
    public void initBrowser()  {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));

        Selenide.open(TestProperties.getProperty("url"));
        getWebDriver().manage().window().maximize();
    }


    @Step("close window")
    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
        }
}
