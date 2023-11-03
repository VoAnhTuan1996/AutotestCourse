import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Day09_Action {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {

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
        handleContextClick();
        Thread.sleep(8000);
        driver.quit();
    }

    public static  void handleContextClick() throws InterruptedException {
        String url = "https://demo.guru99.com/test/simple_context_menu.html";
        driver.get(url);
        //WebElement btnRightClick = driver.findElement(By.xpath("//span[text()='right click method']"));
        Actions actions = new Actions(driver);
        //actions.contextClick(btnRightClick).build().perform();//chuột phải

        WebElement btnDoubleClick = driver.findElement((By.xpath("//button[text()='Double-Click Me To See Alert']")));
        actions.doubleClick(btnDoubleClick).build().perform();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
    }
}
