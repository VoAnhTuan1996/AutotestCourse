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
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        loginCustomerAccount();
        Thread.sleep(18000);
        driver.quit();
    }

    public static void loginCustomerAccount() throws InterruptedException {
        String text = "test";
        driver.switchTo().frame("login_page");
        WebElement userIDTxtbox = driver.findElement(By.xpath("//input[@name='fldLoginUserId']"));
        userIDTxtbox.sendKeys("test");
        WebElement btnContinue = driver.findElement(By.xpath("//a[text()='CONTINUE']"));
        btnContinue.click();
        WebElement customerIdField = driver.findElement(By.id("forgotCustId"));
        WebElement passwordField = driver.findElement(By.id("forgotPassword"));
        if(customerIdField.isDisplayed()==true && passwordField.isDisplayed()==true){
            System.out.println("Verification Passed");
        }
        else{
            System.out.println("Verification failed");
        }
    }
}
