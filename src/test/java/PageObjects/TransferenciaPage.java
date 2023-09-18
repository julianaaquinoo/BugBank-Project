package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferenciaPage {

    private WebDriver driver;

    private Waits waits;

    public TransferenciaPage(WebDriver driver){

        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getEmailLogin(){
        return waits.visibilityOfElement(By.name("email"));
    }

    public WebElement getSenhaLogin(){
        return waits.visibilityOfElement(By.xpath("(//input[@type='password' and @class='input__default'])[1]"));
    }

    public WebElement btnAcessar(){
        return waits.visibilityOfElement(By.xpath("//button[@type='submit' and @class='style__ContainerButton-sc-1wsixal-0 otUnI button__child']"));
    }

    public WebElement txtBemVindo(){
        return waits.visibilityOfElement(By.xpath("//p[contains(text(), 'bem vindo ao BugBank')]"));
    }

    public WebElement saldo(){

        return waits.visibilityOfElement((By.xpath("//p[@id= 'textBalance']")));

    }

    public WebElement btnTransferencia(){

        return waits.visibilityOfElement(By.xpath("//div[@class='home__ContainerButton-sc-1auj767-14 ebzpKL'][1]"));
    }

    public WebElement numeroDaConta(){

        return waits.visibilityOfElement(By.xpath("//input[@class='input__default' and@name='accountNumber']"));
    }

    public WebElement digito(){

        return waits.visibilityOfElement(By.xpath("//input[@class='input__default' and@name='digit']"));
    }

    public WebElement valorDaTransferencia(){

        return waits.visibilityOfElement(By.xpath("//input[@class='input__default' and@name='transferValue']"));
    }

    public WebElement descricao(){

        return waits.visibilityOfElement(By.xpath("//input[@class='input__default' and@name='description']"));
    }

    public WebElement btnTransferirAgora(){

        return waits.visibilityOfElement(By.xpath("//button[@class='style__ContainerButton-sc-1wsixal-0 CMabB button__child']"));
    }

    public WebElement txtTransferenciaRealizada(){

        return waits.visibilityOfElement(By.xpath("//p[@class='styles__Text-sc-8zteav-4 gpcLtj']"));
    }

    public WebElement btnFechar(){

        return waits.visibilityOfElement(By.xpath("//a[@id='btnCloseModal' and contains(@class, 'styles__Button-sc-8zteav-5')]"));
    }

    public WebElement btnVoltar(){

        return waits.visibilityOfElement(By.xpath("//a[@class='transfer__BackText-sc-1yjpf2r-5 gWmJSZ']"));
    }

    public WebElement btnExtrato(){

        return waits.visibilityOfElement(By.xpath("//a[@id='btn-EXTRATO']"));
    }

    public WebElement saldoConta1(){

        return waits.visibilityOfElement((By.xpath("//p[@id= 'textBalanceAvailable']")));

    }

    public WebElement btnSair(){

        return waits.visibilityOfElement(By.id("btnExit"));

    }

}
