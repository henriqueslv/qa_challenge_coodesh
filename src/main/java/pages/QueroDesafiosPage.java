package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QueroDesafiosPage {
    private WebDriver driver;

    private By formCategoria = By.name("search");

    public QueroDesafiosPage(WebDriver driver) {
        this.driver = driver;
    }

    public void formCategoria(){
        driver.findElement(formCategoria).click();
        driver.findElement(formCategoria).sendKeys("Testar se o botao Quero Desafios direcionou corretamente");
    }


}
