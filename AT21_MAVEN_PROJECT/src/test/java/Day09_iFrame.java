import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Day09_iFrame {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_test";
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
        switchToIFrame();
        Thread.sleep(8000);
        driver.quit();
    }

    public static void switchToIFrame(){
        //switch to frame với webElement
        WebElement frameInput = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(frameInput);
        WebElement txt1 = driver.findElement(By.id("fname"));
        txt1.sendKeys("aaa");
        WebElement txt2 = driver.findElement(By.id("lname"));
        txt2.sendKeys("bbb");

        //switch to frame với attribute là id hoặc name
       /* driver.switchTo().frame("iframeResult");//index/attribute :id hoặc name//webElement
        WebElement txt1 = driver.findElement(By.id("fname"));
        txt1.sendKeys("aaaa");*/

        //switch to frame với index
       /* driver.switchTo().frame(0);
        WebElement txt1 = driver.findElement(By.id("fname"));
        txt1.sendKeys("aaaa");
*/
    }
}
