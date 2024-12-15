package pagesTest;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class TestPage {
    private final SelenideElement searchProject = $x("//a[@id='browse_link']");
    private final SelenideElement clickTest = $x("//a[@id='admin_main_proj_link_lnk']");
    private final SelenideElement searchInput = $x("//input[@id='quickSearchInput']");
    private final SelenideElement countTasks = $x("//div[@class='showing']//child::span");

    @Step("search project")
    public void projectTest() {
        searchProject.click();
        clickTest.click();
    }
    @Step("search text")
    public void searchText(String text) {
        searchInput.sendKeys(text);
        searchInput.pressEnter();
    }
    @Step("count task")
    public int countTask() {
        String countTaskText = countTasks.getText();
        String[] parts = countTaskText.split(" ");
        return Integer.parseInt(parts[2]);
    }
}
