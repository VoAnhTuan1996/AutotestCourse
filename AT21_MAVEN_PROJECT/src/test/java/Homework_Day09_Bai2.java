import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Homework_Day09_Bai2 {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://demoqa.com/frames";
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
        driver.switchTo().frame("frame1");
        WebElement txt1 = driver.findElement(By.id("sampleHeading"));
        System.out.println(txt1.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        WebElement txt2 = driver.findElement(By.id("sampleHeading"));
        System.out.println(txt2.getText());
    }
}
