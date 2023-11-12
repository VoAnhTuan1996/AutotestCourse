import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Homework_Day10_bai4 {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://tiemchungcovid19.gov.vn/portal/register-person";
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
        registerRelativesPerson();
        Thread.sleep(7000);
        driver.quit();
    }

    public static void registerRelativesPerson() throws InterruptedException {
        WebElement rdB = driver.findElement(By.xpath("//label[@for='mat-radio-3-input']//div[@class='mat-radio-inner-circle']"));
        rdB.click();
        Thread.sleep(5000);
    }
}
