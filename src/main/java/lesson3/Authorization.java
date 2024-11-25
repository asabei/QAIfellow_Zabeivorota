package lesson3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Authorization {
    private static final SelenideElement profileLogo = $x("//a[@id='header-details-user-fullname']");
    private static final SelenideElement subTitle = $x("//h1/span[@id='issues-subnavigation-title']");

    public static Boolean isLogoVisible() {
        waitSignIn();
        return profileLogo.isDisplayed();
    }

    public static void waitSignIn() {
        profileLogo.shouldBe(Condition.visible);
    }

    public static Boolean isTitleExists(String title) {
        return subTitle.getText().equals(title);
    }
}
