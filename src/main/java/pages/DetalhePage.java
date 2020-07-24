package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetalhePage {
    private WebDriver driver;

    private By nomeVaga = By.cssSelector(".h4.mb-1");

    private By nomeEmpresa = By.cssSelector("span.link-muted");

    private By botaoCandidatar = By.cssSelector(".text-center button");

    public DetalhePage(WebDriver driver) {
        this.driver = driver;
    }

    public String obterNomeDaVaga(){
        return driver.findElement(nomeVaga).getText();
    }

    public String obterNomeDaEmpresa(){
        return driver.findElement(nomeEmpresa).getText();
    }

    public ModalPage clicarBotaoCandidatar(){
        driver.findElement(botaoCandidatar).click();
        return new ModalPage(driver);
    }
}
