package lesson3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class StartPage {
    private final SelenideElement userName = $x("//input[@name='os_username']");
    private final SelenideElement password = $x("//input[@name='os_password']");
    private final SelenideElement logButton = $x("//input[@name='login']");

    public void login(String log, String pass){
        userName.shouldBe(Condition.visible);
        password.shouldBe(Condition.visible);
        userName.setValue(log);
        password.setValue(pass);
        logButton.click();
    }

}
