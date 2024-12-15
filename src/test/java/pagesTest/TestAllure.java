package pagesTest;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import util.TestProperties;
import webhooks.WebHooks;
import java.util.List;

public class TestAllure extends WebHooks {
    private final StartPage page = new StartPage();
    private final Authorization authorizationTask = new Authorization();
    private final TestPage pageTest = new TestPage();
    private final JiraTask jiraTask = new JiraTask();
    private final CreateTask createTask = new CreateTask();
    private String log = TestProperties.getProperty("login");
    private String pass = TestProperties.getProperty("password");
    private int initTaskCount;
    private int afterTaskCount;

    @Test
    @DisplayName("check autorization")
    public void loginTest() {
        page.login(log, pass);
        Assertions.assertTrue(authorizationTask.isLogoVisible());
    }
    @Test
    @DisplayName("go to project Test")
    public void projectTest() {
        page.login(log, pass);
        pageTest.projectTest();
        Assertions.assertTrue(Authorization.isTitleExists("Открытые задачи"));
    }
    @Test
    @DisplayName("check and update rows")
    public void taskTestSelenium(){
        page.login(log, pass);
        Authorization.waitSignIn();
        pageTest.searchText("TestSeleniumATHomework");
        List<String> projectStatus = jiraTask.statusCheck();
        Assertions.assertEquals("СДЕЛАТЬ", projectStatus.get(0));
        Assertions.assertEquals("Version 2.0", projectStatus.get(1));
    }
    @Test
    @DisplayName("create new bug")
    public  void CreatJiraTask(){
        page.login(log, pass);
        pageTest.projectTest();
        initTaskCount = pageTest.countTask();
        createTask.createNewTask("bug","describe" );
        Selenide.refresh();
        afterTaskCount = pageTest.countTask();
        Assertions.assertEquals(initTaskCount, afterTaskCount-1);
    }
    @Test
    @DisplayName("change status")
    public void CaStatus(){
        page.login(log, pass);
        pageTest.projectTest();
        createTask.statusChange();
    }
}
