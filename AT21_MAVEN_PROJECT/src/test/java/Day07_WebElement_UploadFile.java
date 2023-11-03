import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Day07_WebElement_UploadFile {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://file.io/";
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
        uploadFile();
        Thread.sleep(7000);
        driver.quit();
    }

    public static void uploadFile() {
        String path = System.getProperty("user.dir");
        String imgFile = path + "\\src\\test\\resources\\images.jpg";
        System.out.printf(imgFile);
        WebElement uploadFileCustom = driver.findElement(By.xpath("//input[@type='file']"));
        uploadFileCustom.sendKeys(imgFile);
    }

}
