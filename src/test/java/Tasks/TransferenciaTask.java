package Tasks;

import PageObjects.TransferenciaPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import Framework.Utils.FilesOperation;

import java.io.IOException;

public class TransferenciaTask {

    private WebDriver driver;

    private TransferenciaPage transferenciaPage;

    public TransferenciaTask(WebDriver driver){

        this.driver =driver;
        transferenciaPage = new TransferenciaPage(this.driver);
    }



    public void realizarTransferencia(){

        transferenciaPage.getEmailLogin().sendKeys("123@automacao.com.br");
        transferenciaPage.getSenhaLogin().sendKeys("1234");
        transferenciaPage.btnAcessar().click();
        transferenciaPage.txtBemVindo().getText();
        String msg = "bem vindo ao BugBank :)";
        Assert.assertEquals(msg, transferenciaPage.txtBemVindo().getText());
        transferenciaPage.saldo().getText();
        transferenciaPage.btnTransferencia().click();

        String numeroDaContaFormatado = null;
        String digitoDaConta = null;
        try {
            numeroDaContaFormatado = FilesOperation.getProperties("conta").getProperty("numeroConta");
            digitoDaConta = FilesOperation.getProperties("conta").getProperty("digitoConta");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        transferenciaPage.numeroDaConta().sendKeys(numeroDaContaFormatado);
        transferenciaPage.digito().sendKeys(digitoDaConta);
        transferenciaPage.valorDaTransferencia().sendKeys("500");
        transferenciaPage.descricao().sendKeys("Teste Automação");
        transferenciaPage.btnTransferirAgora().click();
        transferenciaPage.txtTransferenciaRealizada().isDisplayed();
        String mensagem = "Transferencia realizada com sucesso";
        Assert.assertEquals(mensagem, transferenciaPage.txtTransferenciaRealizada().getText());
        transferenciaPage.btnFechar().click();
        transferenciaPage.btnVoltar().click();
        transferenciaPage.btnExtrato().click();
        transferenciaPage.saldoConta1().getText();

        String saldoConta1 = transferenciaPage.saldoConta1().getText();
        String[] splitSaldoConta1 = saldoConta1.split("-");

        String saldoFormatado = splitSaldoConta1[0].replaceAll("[^0-9]", "");
        try {
            FilesOperation.setProperty("saldo", "saldoConta1", saldoFormatado);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String validaSaldo1 = "R$ 500,00";
        Assert.assertEquals(validaSaldo1,transferenciaPage.saldoConta1().getText());

        transferenciaPage.btnSair().click();

    }

    public void validarTransferencia(){
        transferenciaPage.getEmailLogin().sendKeys("456@automacao.com.br");
        transferenciaPage.getSenhaLogin().sendKeys("1234");
        transferenciaPage.btnAcessar().click();
        transferenciaPage.txtBemVindo().getText();
        String msg = "bem vindo ao BugBank :)";
        Assert.assertEquals(msg, transferenciaPage.txtBemVindo().getText());
        transferenciaPage.saldo().getText();

        String saldoConta2 = transferenciaPage.saldo().getText();
        String[] splitSaldoConta2 = saldoConta2.split("-");

        String saldoFormatado = splitSaldoConta2[0].replaceAll("[^0-9]", "");
        try {
            FilesOperation.setProperty("saldo", "saldoConta2", saldoFormatado);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String validaSaldo2 = "Saldo em conta R$ 500,00";
        Assert.assertEquals(validaSaldo2, transferenciaPage.saldo().getText());

    }
}
