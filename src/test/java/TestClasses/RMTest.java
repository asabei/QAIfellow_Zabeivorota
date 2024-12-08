package TestClasses;

import hooks.WebHooks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ApiRMSteps;


public class RMTest extends WebHooks {
    @Test
    @DisplayName("Test api Rick and Morty")
    public void RickAndMortyTest(){
        new ApiRMSteps()
                .apiRm("https://rickandmortyapi.com/api",200);
    }
}
