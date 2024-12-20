package steps;

import io.cucumber.java.ru.И;
import pages.ApiRM;


public class RM {
    @И("РМ тест")
    public void сompareСharactersTest(){
        new ApiRM()
                .apiRm("https://rickandmortyapi.com/api",200);
    }
}