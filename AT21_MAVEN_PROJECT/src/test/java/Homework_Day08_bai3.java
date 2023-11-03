import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Homework_Day08_bai3 {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://demoqa.com/select-menu";
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
        customDropdown();
        //defaultDropdown();
        Thread.sleep(7000);
        driver.quit();
    }

    public static void customDropdown(){
        WebElement dropSelectValue = driver.findElement(By.id("withOptGroup"));
        dropSelectValue.click();
        WebElement btnItem1 = driver.findElement(By.xpath("//div[text()='Another root option']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",btnItem1);

    }
}
