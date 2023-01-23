package menu;

import ejecucionProgramas.EjecutarPage;
import login.LoginPage;
import login.NavigateActions;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class MenuTest {

    /**
     * Define the webdriver instance to be used for these tests
     */
    @Managed
    WebDriver driver;

    /**
     * Navigation actions. This is a UIInteraction class so it will be instantiated automatically by Serenity.
     */
    NavigateActions navigate;

    /**
     * Actions related to searches. This is a UIInteraction class so it will be instantiated automatically by Serenity.
     */

    LoginPage loginPage;
    EjecutarPage ejecutarPage;

    MenuPage menuPage;


    @Test
    @Title("Load Run programs page")
    @WithTag("menu")
    void runProgramasPageSuccesful() {

        // When
        navigate.toTheHomePage ();

        // And
        loginPage.login ();

        // And
        menuPage.toEjecutar ();

        System.out.println ( ejecutarPage.GetTitle () );


        // Then
        Serenity.reportThat ( "The EjecutarProgramas page is show",
                              () -> assertThat ( true ) );
    }


}