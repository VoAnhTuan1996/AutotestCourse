package test;

import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Obj.LoginPage_Obj;

public class TC_Login extends BaseTest {
    LoginPage_Obj objLogin;
    @BeforeMethod
    public void openUrl(){
        String url = BaseUrl + "insurance/v1/index.php";
        driver.get(url);
        objLogin = new LoginPage_Obj(driver);
    }
    @Test
    public void createAccount(){
        objLogin.enterToEmail("harrytuan549@gmail.com");
        objLogin.enterToPassword("123456");
        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='Log in']"));
        btnLogin.click();
    }
}
