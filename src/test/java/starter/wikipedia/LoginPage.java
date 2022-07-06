package starter.wikipedia;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class LoginPage extends PageObject {

    @FindBy(using = "_USER")
    WebElementFacade txtUsername;

    @FindBy(using = "_PASSWORD")
    WebElementFacade txtPassword;

    @FindBy(using = "BTNOPINICIARSESION")
    WebElementFacade submitButton;

    @FindBy(id = "spanMessage")
    WebElementFacade errorMessage;

    @FindBy(xpath = "//*[@id='forgotPasswordLink']/a")
    WebElementFacade forgotPasswordLinkText;

    @Step("Enter Username")
    public void inputUserName(String userName) {
        txtUsername.sendKeys((userName));
    }

    @Step("Enter Password")
    public void inputPassword(String passWord) {
        txtPassword.sendKeys((passWord));
    }

    @Step("Click Submit Button")
    public void clickLogin() {
        submitButton.click();
    }

    @Step("Error Message on unsuccessful login")
    public String loginPageErrorMessage() {
        return errorMessage.getText();
    }

    @Step("Click Forget Password Link")
    public void clickForgetPasswordLink() {
        forgotPasswordLinkText.click();
    }
}