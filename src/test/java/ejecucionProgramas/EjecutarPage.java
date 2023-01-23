package ejecucionProgramas;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;


public class EjecutarPage extends PageObject {

    @FindBy(using = "_PROGRAMA")
    WebElementFacade _PROGRAMA;

    @FindBy(using = "BTNOPCONFIRMAR")
    WebElementFacade BTNOPCONFIRMAR;

    @FindBy(using = "HTMLTXTTITLE1")
    WebElementFacade Title;


    @Step("Click Confirmar")
    public void Confirmar() {

        BTNOPCONFIRMAR.click ();

    }

    @Step("Get title on Ejecutar Programas")
    public String GetTitle() {

        return Title.getTextContent ();

    }


}