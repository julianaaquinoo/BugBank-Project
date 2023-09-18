//package PageObjects;
//
//import Framework.Browser.Waits;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//public class LoginPage {
//
//    private WebDriver driver;
//
//    private Waits waits;
//
//    public LoginPage(WebDriver driver){
//
//        this.driver = driver;
//        waits = new Waits(this.driver);
//    }
//
//    public WebElement getEmailLogin(){
//        return waits.visibilityOfElement(By.name("email"));
//    }
//
//    public WebElement getSenhaLogin(){
//        return waits.visibilityOfElement(By.xpath("(//input[@type='password' and @class='input__default'])[1]"));
//    }
//
//    public WebElement btnAcessar(){
//        return waits.visibilityOfElement(By.xpath("//button[@type='submit' and @class='style__ContainerButton-sc-1wsixal-0 otUnI button__child']"));
//    }
//
//    public WebElement txtBemVindo(){
//        return waits.visibilityOfElement(By.xpath("//p[contains(text(), 'bem vindo ao BugBank')]"));
//    }
//
//    public WebElement saldo(){
//
//        return waits.visibilityOfElement((By.xpath("//p[@id= 'textBalance']")));
//
//    }
//
//}
