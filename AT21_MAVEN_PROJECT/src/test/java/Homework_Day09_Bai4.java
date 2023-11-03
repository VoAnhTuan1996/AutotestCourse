import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Homework_Day09_Bai4 {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://netbanking.hdfcbank.com/netbanking/";
        String browser = "Chrome";
        switch (browser) {
            case "Chrome":
                driver = WebDriverManager.chromedriver().create();
                break;
            case "Firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
            default:
                System.out.println("Chưa chọn browser");
                break;
        }
        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        loginCustomerAccount();
        Thread.sleep(8000);
        driver.quit();
    }

    public static void loginCustomerAccount(){
        String text = "test";
        WebElement txtUsernameField = driver.findElement(By.xpath("//input[@id='liabiltyLoginCustId']"));
        txtUsernameField.sendKeys(text);
        WebElement btnLogin = driver.findElement(By.id("continuelogin"));
        btnLogin.click();
        System.out.println(txtUsernameField.getAttribute("value").equals(text));
    }
}
