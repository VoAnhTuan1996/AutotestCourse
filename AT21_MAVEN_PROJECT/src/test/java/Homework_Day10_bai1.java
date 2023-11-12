import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Homework_Day10_bai1 {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_date";
        String browser = "Firefox";
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
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        sendKeyInputTime();
        Thread.sleep(7000);
        driver.quit();
    }

    public static void sendKeyInputTime() throws InterruptedException {
        driver.switchTo().frame("iframeResult");
        WebElement inputDate = driver.findElement(By.id("birthday"));
        ((JavascriptExecutor)driver).executeScript ( "arguments[0].removeAttribute('type')",inputDate);
        inputDate.sendKeys("15-01-1996");
        System.out.println(inputDate.getText());
        WebElement btnSubmit = driver.findElement(By.xpath("//input[@type='submit']"));
        btnSubmit.click();
        Thread.sleep(5000);
    }

}
