package login;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.util.Set;


public class LoginPage extends PageObject {

    @FindBy(using = "_USER")
    WebElementFacade txtUsername;

    @FindBy(using = "_PASSWORD")
    WebElementFacade txtPassword;

    @FindBy(using = "BTNOPINICIARSESION")
    WebElementFacade submitButton;

    @FindBy(using = "MsgText")
    WebElementFacade errorMessage;

    Credentials credentials = new Credentials ();

    @Step("Auto Login with Credentials")
    public void login() {
        inputUserName ( credentials.username );
        inputPassword ( credentials.password );
        clickLogin ();
        switchToNewMainWindows ();
    }

    @Step("Enter Username")
    public void inputUserName(String userName) {
        txtUsername.sendKeys ( (userName) );
    }

    @Step("Enter Password")
    public void inputPassword(String passWord) {
        txtPassword.sendKeys ( (passWord) );
    }

    @Step("Click Submit Button")
    public void clickLogin() {
        submitButton.click ();
    }

    @Step("Switching to Main Page after Login")
    public void switchToNewMainWindows() {
        // To handle parent window
        String MainWindow = getDriver ().getWindowHandle ();
//        System.out.println("Main window handle is " + MainWindow);

        // To handle child window
        Set<String> s1 = getDriver ().getWindowHandles ();
        //System.out.println ( "Child window handle is" + s1 );
        for (String ChildWindow : s1) {
            if ( !MainWindow.equalsIgnoreCase ( ChildWindow ) ) {
                getDriver ().switchTo ().window ( ChildWindow );
                //String pageTitle = driver.getTitle ();
                //System.out.println("The web page title of child window is:"+pageTitle);
                getDriver ().manage ().window ().maximize ();
                break;
            }
        }
    }

    @Step("Error Message on unsuccessful login")
    public String loginPageErrorMessage() {
        return errorMessage.getText ();
    }

}