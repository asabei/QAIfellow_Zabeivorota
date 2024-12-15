package pagesTest;
import java.util.List;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class JiraTask {
    private final SelenideElement status =$x("//span[@id='status-val']/child::span");
    private final SelenideElement version =$x("//span[@id='fixfor-val']");


    @Step("status check")
    public List<String> statusCheck() {
        String statusText = status.shouldBe(Condition.visible).getText();
        String versionText = version.shouldBe(Condition.visible).getText();
        return List.of(statusText, versionText);
    }
}