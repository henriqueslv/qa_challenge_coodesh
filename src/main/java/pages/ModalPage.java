package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ModalPage {
    private WebDriver driver;

    private By modalNome = By.id("fullname");

    private By modalEmail = By.id("email");

    private By modalTelefone = By.id("phone");

    private By modalCidade = By.id("city");

    private By modalLinkedin = By.id("linkedin");

    private By modalGitHub = By.id("github");

    private By modalSalario = By.id("salary_range.max");

    private By modalPreferenciaDeContato = By.id("contact_preference");

    private By modalHorarioContato = By.id("contact_hour");


    public ModalPage(WebDriver driver) {
        this.driver = driver;
    }

    public void nomeModal(){
        driver.findElement(modalNome).clear();
        driver.findElement(modalNome).sendKeys("Joao Da Silva");
    }

    public void emailModal(){
        driver.findElement(modalEmail).clear();
        driver.findElement(modalEmail).sendKeys("joaosilva123@gmail.com");
    }
    public void telefoneModal(){
        driver.findElement(modalTelefone).clear();
        driver.findElement(modalTelefone).sendKeys("8199999-9999");
    }
    public void cidadeModal(){
        driver.findElement(modalCidade).clear();
        driver.findElement(modalCidade).sendKeys("Recife");
    }
    public void linkedinModal(){
        driver.findElement(modalLinkedin).clear();
        driver.findElement(modalLinkedin).sendKeys("www.linkedin.com/in/joao123silva/");
    }
    public void githubModal(){
        driver.findElement(modalGitHub).clear();
        driver.findElement(modalGitHub).sendKeys("www.github.com/joao123silva");
    }
    public void salarioModal(){
        driver.findElement(modalSalario).click();
        driver.findElement(modalSalario).clear();
        driver.findElement(modalSalario).sendKeys("23354");
    }

    public Select encontrarDropDown(){
        return new Select(driver.findElement(modalPreferenciaDeContato));
    }

    public List<String> obterOpcoesSelecionadas(){
        List<WebElement> elementosSelecionados = encontrarDropDown().getAllSelectedOptions();

        List<String> listaOpcoesSelecionadas =  new ArrayList();
        for(WebElement element : elementosSelecionados){
            listaOpcoesSelecionadas.add(element.getText());
        }
        return  listaOpcoesSelecionadas;
    }

    public void selecionarOpcaoDropDown(String opcao){
        encontrarDropDown().selectByVisibleText(opcao);
    }

    public Select encontrarDropDownHorarioContato(){
        return new Select(driver.findElement(modalHorarioContato));
    }

    public List<String> obterOpcoesSelecionadasHorarioContato(){
        List<WebElement> elementosSelecionadosHorarioContato = encontrarDropDownHorarioContato().getAllSelectedOptions();

        List<String> listaOpcoesSelecionadasHorarioContato =  new ArrayList();
        for(WebElement element : elementosSelecionadosHorarioContato){
            listaOpcoesSelecionadasHorarioContato.add(element.getText());
        }
        return  listaOpcoesSelecionadasHorarioContato;
    }

    public void selecionarOpcaoDropDownHorarioContato(String opcao){
        encontrarDropDownHorarioContato().selectByVisibleText(opcao);
    }



}
