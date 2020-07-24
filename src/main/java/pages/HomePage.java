package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    //Lista de Vagas
    List<WebElement> listaVagas = new ArrayList<WebElement>();

    // Elementos da tela
    private By cards = By.cssSelector(".media");

    private By btn = By.cssSelector("a.transition-3d-hover");

    private By display = By.cssSelector("h1.display-5.font-size-md-down-5.mb-3");

    private By menu = By.cssSelector(".nav-link.u-header__nav-link");

    private By queroContratar = By.cssSelector("div.d-flex.align-items-center.flex-wrap a");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }




    public void carregarLista(){
        listaVagas = driver.findElements(cards);
    }

    public int contarLista(){
        carregarLista();
        return listaVagas.size();
    }

    public String obterTitulo(){
        return driver.getTitle();
    }

    public QueroContratarPage botaoQueroContratar(){
        driver.findElement(queroContratar).getText();
        return new QueroContratarPage(driver);
    }

    public QueroDesafiosPage botaoQueroDesafios(){
        driver.findElements(btn).get(1).click();
        return new QueroDesafiosPage(driver);
    }


    public String obterNomeDisplay(){
        return driver.findElement(display).getText();
    }

    public VagasPage menuVagas(){
        driver.findElements(menu).get(2).getText();
        driver.findElements(menu).get(2).click();
        return new VagasPage(driver);
    }

    public SolicitarPropostaPage solicitarProposta(){
        driver.findElements(menu).get(4).getText();
        driver.findElements(menu).get(4).click();
        return new SolicitarPropostaPage(driver);
    }
}
