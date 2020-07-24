package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SolicitarPropostaPage {
    private WebDriver driver;

    private By textoConfirmacao = By.cssSelector(".h4");

    public SolicitarPropostaPage(WebDriver driver) {
        this.driver = driver;
    }

    public String obterTextoCandidato(){
        return driver.findElements(textoConfirmacao).get(0).getText();
    }

}
