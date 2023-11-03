import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Homework_Day08_bai2 {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://demo.guru99.com/test/upload/";
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
        submitFile();
        Thread.sleep(7000);
        driver.quit();
    }

    public static void submitFile() {
        WebElement cbTerm = driver.findElement(By.xpath("//input[@id='terms']"));
        cbTerm.click();
        WebElement btnSubmit = driver.findElement(By.xpath("//button[@id='submitbutton']"));
        btnSubmit.click();
    }

}
