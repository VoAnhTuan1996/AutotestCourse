import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Day08_Alert {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://demoqa.com/alerts";
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
        //simpleAlert();
        //confirmAlert();
        promptAlert();
        Thread.sleep(8000);
        driver.quit();
    }

    public static void simpleAlert(){
        WebElement simpleAlert = driver.findElement(By.id("alertButton"));
        simpleAlert.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    public static void confirmAlert(){
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
    }

    public static void promptAlert(){
        WebElement promptButton = driver.findElement(By.id("promtButton"));
        promptButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Naaaa");
        alert.accept();
    }
}
