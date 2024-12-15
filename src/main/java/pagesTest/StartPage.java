package pagesTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class StartPage {
    private final SelenideElement userName = $x("//input[@name='os_username']");
    private final SelenideElement passwor = $x("//input[@name='os_password']");
    private final SelenideElement logButton = $x("//input[@name='login']");

    @Step("Log in")
    public void login(String log, String pass){
        userName.shouldBe(Condition.visible);
        passwor.shouldBe(Condition.visible);
        userName.setValue(log);
        passwor.setValue(pass);
        logButton.click();
    }

}
