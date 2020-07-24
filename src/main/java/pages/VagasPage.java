package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



public class VagasPage {
    private WebDriver driver;

    private By formCategoria = By.name("search");

    private By cards = By.cssSelector("h1.h5.mb-1 a");

    private By nomeDaEmpresa = By.cssSelector("span.link-muted");

    private By vagaPresencial= By.cssSelector(".mb-5.card li.list-inline-item:nth-child(3)");


    public VagasPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inserirDados(String nomeVaga){
        driver.findElement(formCategoria).click();
        driver.findElement(formCategoria).clear();
        driver.findElement(formCategoria).sendKeys(nomeVaga);
        driver.findElement(formCategoria).sendKeys(Keys.ENTER);
    }


    public String obterNome(int indice){
        return driver.findElements(cards).get(indice).getText();
    }

    public DetalhePage clicarNaVaga(int indice){
        driver.findElements(cards).get(indice).click();
        return new DetalhePage(driver);
    }

    public String obterNomeDaEmpresa(){
        return driver.findElement(nomeDaEmpresa).getText();
    }
}
