package Tasks;

import ToolBox.Utils.FilesOperation;
import PageObjects.CadastroPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CadastroTask {

    private WebDriver driver;
    private CadastroPage cadastroPage;

    public CadastroTask (WebDriver driver){

        this.driver =driver;

        cadastroPage = new CadastroPage(this.driver);
    }

    public void realizaCadastro1(){

        cadastroPage.btnRegistrar().click();
        cadastroPage.getemail().sendKeys("123@automacao.com.br");
        cadastroPage.getNome().sendKeys("joao");
        cadastroPage.getSenha().sendKeys("1234");
        cadastroPage.getconfirmaSenha().sendKeys("1234");
        cadastroPage.getSaldo().click();
        cadastroPage.btnCadastrar().click();
        cadastroPage.numeroDaConta().getText();
        cadastroPage.btnFechar().click();
    }

    public void realizarCadastro2(){

        cadastroPage.btnRegistrar().click();
        cadastroPage.getemail().clear();
        cadastroPage.getemail().sendKeys("456@automacao.com.br");
        cadastroPage.getNome().clear();
        cadastroPage.getNome().sendKeys("Maria");
        cadastroPage.getSenha().clear();
        cadastroPage.getSenha().sendKeys("1234");
        cadastroPage.getconfirmaSenha().clear();
        cadastroPage.getconfirmaSenha().sendKeys("1234");
        cadastroPage.btnCadastrar().click();
        cadastroPage.numeroDaConta().getText();
        cadastroPage.digitoDaConta().getText();

        String numeroDaConta = cadastroPage.numeroDaConta().getText();
        String[] splitNumeroDaConta = numeroDaConta.split("-");

        String numeroDaContaFormatado = splitNumeroDaConta[0].replaceAll("[^0-9]", "");
        String digitoDaConta = splitNumeroDaConta[1].replaceAll("[^0-9]", "");
        try {
            FilesOperation.setProperty("conta", "numeroConta", numeroDaContaFormatado);
            FilesOperation.setProperty("conta", "digitoConta", digitoDaConta);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        cadastroPage.btnFechar().click();

    }
}
