import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Homework_Day09_Bai5 {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://demo.guru99.com/test/drag_drop.html";
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
        dragDrop();
        Thread.sleep(18000);
        driver.quit();
    }

    public static void dragDrop() throws InterruptedException {
        WebElement from1 = driver.findElement(By.id("credit2"));
        WebElement to1 = driver.findElement(By.id("bank"));
        WebElement from2 = driver.findElement(By.id("credit1"));
        WebElement to2 = driver.findElement(By.id("loan"));
        WebElement from3 = driver.findElement(By.xpath("//li[@id='fourth'][1]"));
        WebElement to3 = driver.findElement(By.id("amt7"));
        WebElement from4 = driver.findElement(By.xpath("//li[@id='fourth'][2]"));
        WebElement to4 = driver.findElement(By.id("amt8"));

        Actions builder = new Actions(driver);
        builder.dragAndDrop(from1, to1).build().perform();
        Thread.sleep(3000);
        builder.dragAndDrop(from2, to2).build().perform();
        Thread.sleep(3000);
        builder.dragAndDrop(from3, to3).build().perform();
        Thread.sleep(3000);
        builder.dragAndDrop(from4, to4).build().perform();
        Thread.sleep(3000);
    }
}
