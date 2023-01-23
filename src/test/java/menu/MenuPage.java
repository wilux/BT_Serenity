package menu;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.util.Set;


public class MenuPage extends PageObject {

    @FindBy(using = "menuBase")
    WebElementFacade Menu;

    @FindBy(xpath = "//a[@init='m0_1']")
    WebElementFacade Accesos;

    @FindBy(xpath = "//a[@class='leafCompementWithShortcut']")
    WebElementFacade Ejecutar;

    @FindBy(xpath = "//a[@init='m0_0']")
    WebElementFacade Inicio;

    @FindBy(xpath = "//a[@init='m1_0']")
    WebElementFacade WF;

    @FindBy(xpath = "//a[.='BANDEJA DE TAREAS']")
    WebElementFacade BandejaTareas;

    @FindBy(using = "_PROGRAMA")
    WebElementFacade _PROGRAMA;

    @FindBy(using = "BTNOPCONFIRMAR")
    WebElementFacade BTNOPCONFIRMAR;

    @FindBy(using = "//a[.='Salir']")
    WebElementFacade Logout;

    @Step("Click Logout")
    public void logout() {

        Logout.click ();

    }

    @Step("Click Accesos")
    public void accesos() {

        Accesos.click ();

    }

    @Step("Click Accesos -> Ejecutar")
    public void toEjecutar() {
        accesos ();
        Ejecutar.click ();

    }


}