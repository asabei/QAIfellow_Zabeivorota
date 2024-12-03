package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TestPage {
    private final SelenideElement searchProject = $x("//a[@id='browse_link']");
    private final SelenideElement clickTest = $x("//a[@id='admin_main_proj_link_lnk']");
    private final SelenideElement searchInput = $x("//input[@id='quickSearchInput']");
    private final SelenideElement countTasks = $x("//div[@class='showing']/span");


    public void projectTest() {
        searchProject.click();
        clickTest.click();
    }

    public void searchText(String text) {
        searchInput.sendKeys(text);
        searchInput.pressEnter();
    }

    public int countTask() {
        String countTaskText = countTasks.getText();
        String[] parts = countTaskText.split(" ");
        return Integer.parseInt(parts[2]);
    }
}
