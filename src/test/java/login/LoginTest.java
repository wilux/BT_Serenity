package login;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class LoginTest {

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
    MainPage mainPage;

    LoginPage loginPage;

    Credentials credentials = new Credentials ();



    @Test
    @Title("Login to application with valid credentials navigates to DashBoard page")

    void successfulLogin() {

        navigate.toTheHomePage();

        // When
        loginPage.inputUserName(credentials.username);
        loginPage.inputPassword(credentials.password);
        loginPage.clickLogin();

        // Then
        Serenity.reportThat("Passing valid credentials navigates to Main page",
                            () -> assertThat(mainPage.mainLogo));
    }

    @Test
    @Title("Login to application with invalid credential generates error message")
    void unsuccessfulLogin() {

        navigate.toTheHomePage();

        // When
        loginPage.inputUserName("Admin");
        loginPage.inputPassword("admin1232");
        loginPage.clickLogin();

        // Then
        Serenity.reportThat("Passing invalid credentials generates error message",
                            () -> assertThat(mainPage.mainLogo));
    }

}