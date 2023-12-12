package pages.Obj;
import core.BasePage;
import org.openqa.selenium.WebDriver;
import pages.UI.LoginUI;

public class LoginPage_Obj extends BasePage{
    WebDriver driver;
    public LoginPage_Obj(WebDriver driver){this.driver = driver;}
    public void enterToEmail(String text){sendKeyToElementByXpath(driver, LoginUI.TXT_EMAIL,text);}
    public void enterToPassword(String text){sendKeyToElementByXpath(driver, LoginUI.TXT_PASSWORD,text);}

}
