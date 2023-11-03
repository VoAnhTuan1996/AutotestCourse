import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Day08_JavaScriptExecutor {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://tiki.vn";
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
        scrollWithJsExecutor();
        Thread.sleep(3000);
        driver.quit();
    }

    public static void scrollWithJsExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element1 = driver.findElement(By.xpath("//div[text()='Bạn có thể thích']"));
        //scroll đến phần tử cố định
        js.executeScript("arguments[0].scrollIntoview(true);",element1);
        //scroll theo pixel
        //js.executeScript("window.scrollBy(0,600)");
        //get url page
        //js.executeScript("return document.URL");
    }

}
