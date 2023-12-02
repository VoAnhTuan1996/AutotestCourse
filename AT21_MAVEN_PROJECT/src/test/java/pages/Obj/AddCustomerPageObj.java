package pages.Obj;
import core.BasePage;
import org.openqa.selenium.WebDriver;
import pages.UI.AddCustomerUI;
public class AddCustomerPageObj extends BasePage{
    WebDriver driver;
    public AddCustomerPageObj(WebDriver driver){this.driver = driver;}
    public void enterFirstNameTxt(String text){sendKeyToElementByXpath(driver,AddCustomerUI.TXT_FIRSTNAME,text);}
    public void enterLastNameTxt(String text){sendKeyToElementByXpath(driver,AddCustomerUI.TXT_LASTNAME,text);}
    public void enterEmailTxt(String text){sendKeyToElementByXpath(driver,AddCustomerUI.TXT_EMAIL,text);}
    public void enterAddressTextArea(String text){sendKeyToElementByXpath(driver,AddCustomerUI.TEXTAREA_ADDRESS,text);}
    public void enterPhoneNumber(String text){sendKeyToElementByXpath(driver,AddCustomerUI.TXT_PHONE,text);}

}
