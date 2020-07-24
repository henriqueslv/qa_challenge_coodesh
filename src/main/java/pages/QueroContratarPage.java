package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QueroContratarPage {
    private WebDriver driver;

    private By texto = By.cssSelector(".mx-md-auto.mb-9 h2");

    public QueroContratarPage(WebDriver driver) {
        this.driver = driver;
    }

    public String textoContratar()
    {
        return driver.findElements(texto).get(1).getText();
    }

}
