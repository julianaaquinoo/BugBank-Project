package TestCases;
import Tasks.CadastroTask;
import Tasks.TransferenciaTask;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import ToolBox.TestBase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RealizarTransferecia extends TestBase{

    private WebDriver driver = getDriver();
    TransferenciaTask transferenciaTask = new TransferenciaTask(driver);
    CadastroTask cadastroTask = new CadastroTask(driver);

    @Test
     public void transferenciaEntreContas(){
        cadastroTask.realizaCadastro1();
        cadastroTask.realizarCadastro2();
        transferenciaTask.realizarTransferencia();
        transferenciaTask.validarTransferencia();
    }
}
