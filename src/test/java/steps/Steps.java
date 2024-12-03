package steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import org.junit.jupiter.api.Assertions;
import pages.*;
import java.util.List;

public class Steps {
    private final StartPage page = new StartPage();
    private final Authorization authorizationTask = new Authorization();
    private final TestPage pageTest = new TestPage();
    private final JiraTask jiraTask = new JiraTask();
    private final CreateTask createTask = new CreateTask();

    private final String log = "AT14";
    private final String pass = "Qwerty123";
    private int initTaskCount;
    private int afterTaskCount;


    @И("Авторизация тест")
    public void loginTest() {
        page.login(log, pass);
        Assertions.assertTrue(authorizationTask.isLogoVisible(), "Авторизация прошла успешно");
    }

    @И("Перейти в проект Тест")
    public void projectTest() {

        pageTest.projectTest();
        Assertions.assertTrue(Authorization.isTitleExists("Открытые задачи"),"Тест прошел");
    }

    @И("Проверить строки")
    public void taskTestSelenium(){

        pageTest.searchText("TestSeleniumATHomework");
        List <String> projectStatus = jiraTask.statusCheck();
        Assertions.assertEquals("СДЕЛАТЬ", projectStatus.get(0));
        Assertions.assertEquals("Version 2.0", projectStatus.get(1));
    }

    @И("Создать новый баг-репорт")
    public  void CreatJiraTask(){

        pageTest.projectTest();
        initTaskCount = pageTest.countTask();
        createTask.createNewTask("bug","describe" );
        Selenide.refresh();
        afterTaskCount = pageTest.countTask();
        Assertions.assertEquals(initTaskCount, afterTaskCount-1);
    }

    @И("Поменять статус")
    public void CaStatus(){
        pageTest.projectTest();
        createTask.statusChange();
    }
}

