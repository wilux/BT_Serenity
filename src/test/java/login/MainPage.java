package login;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class MainPage extends PageObject {

    @FindBy(using = "logo")
    WebElementFacade mainLogo;

    @Step("Heading of Main Page")
    public boolean getUrl() {
        return mainLogo.isPresent ();


    }
}