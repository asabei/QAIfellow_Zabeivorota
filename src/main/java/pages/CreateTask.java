package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CreateTask {

    private final SelenideElement createTask = $x("//a[@id='create_link']");
    private final SelenideElement inputTheme = $x("//input[@id='summary']");
    private final SelenideElement inputDescription = $x("//textarea[@id='description']");
    private final SelenideElement fixVersion = $x("//label[@for='fixVersions']/following-sibling::select//option[@value='10001']");
    private final SelenideElement labelDropDown = $x("//div[@class='jira-multi-select long-field']//span");
    private final SelenideElement label = $x("//li[contains(@id,'tratata')]");
    private final SelenideElement version = $x("//label[@for='versions']/following-sibling::select //option[@value='10001']");
    private final SelenideElement taskDropDown = $x("//div[@class='jira-multi-select long-field jira-issue-picker hasIcon']//span[@class='icon noloading drop-menu']");
    private final SelenideElement task = $x("//ul[@id='поиск-по-истории']/li[1]");
    private final SelenideElement createButton = $x("//input[@value='Создать']");
    private final SelenideElement checkNewTask = $x("//a[@class='issue-created-key issue-link']");
    private final SelenideElement trigger = $x("//a[@class='order-options aui-button aui-style-default jira-aui-dropdown2-trigger']");
    private final SelenideElement labelCheck = $x("//label[@class='item-label checkbox']");
    private final SelenideElement createdTask = $x("//ol[@class='issue-list']/li[1]/a");
    private final SelenideElement inWorkButton = $x("//a[@id='action_id_21']");
    private final SelenideElement bl =$x("//a[@id='opsbar-transitions_more']");
    private final SelenideElement statusIsDone =$x("//span[text()='Выполнено']/parent::a[@role='menuitem']");


    public void createNewTask(String taskTheme, String description) {
        createTask.click();
        inputTheme.shouldBe(visible);
        inputTheme.setValue(taskTheme);
        inputDescription.setValue(description);
        fixVersion.click();
        labelDropDown.click();
        label.shouldBe(visible);
        label.click();
        taskDropDown.click();
        task.click();
        version.click();
        createButton.click();
        checkNewTask.shouldBe(visible);
    }

    public void statusChange(){
        trigger.click();
        labelCheck.click();
        createdTask.shouldBe(visible).click();
        inWorkButton.shouldBe(visible).click();
        inWorkButton.click();
        bl.click();
        statusIsDone.click();

    }
}
