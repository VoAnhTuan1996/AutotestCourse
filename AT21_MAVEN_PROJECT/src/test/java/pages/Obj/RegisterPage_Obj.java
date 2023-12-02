package pages.Obj;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pages.UI.RegisterUI;

public class RegisterPage_Obj extends BasePage {
    WebDriver driver;
    public RegisterPage_Obj(WebDriver driver){
        this.driver = driver;
    }

    public void enterToFirstNameTxt(String text){
        sendKeyToElementByXpath(driver, RegisterUI.TXT_FIRSTNAME,text);
    }

    public void enterToSurNameTxt(String text){
        sendKeyToElementByXpath(driver, RegisterUI.TXT_SURNAME,text);
    }

    public void enterToPhoneNumber(String text) { sendKeyToElementByXpath(driver,RegisterUI.TXT_PHONE,text);}

    public void enterToAddressStreet(String text) { sendKeyToElementByXpath(driver,RegisterUI.TXT_STREET,text);}

    public void enterToCity(String text) { sendKeyToElementByXpath(driver,RegisterUI.TXT_CITY,text);}

    public void enterToCountry(String text) { sendKeyToElementByXpath(driver,RegisterUI.TXT_COUNTRY,text);}

}
