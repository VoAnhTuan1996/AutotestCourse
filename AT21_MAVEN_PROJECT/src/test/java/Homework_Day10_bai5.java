import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Homework_Day10_bai5 {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://jqueryui.com/tooltip/";
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
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        verifyTooltip();
        Thread.sleep(7000);
        driver.quit();
    }

    public static void verifyTooltip() throws InterruptedException {
        WebElement textBoxFrame = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(textBoxFrame);
        WebElement txtAge = driver.findElement(By.id("age"));
        Actions actions = new Actions(driver);
        //hovering
        actions.moveToElement(txtAge).perform();
        // Kiểm tra tooltip xuất hiện
        // Kiểm tra tooltip xuất hiện
        WebElement tooltip = driver.findElement(By.cssSelector(".ui-tooltip"));
        if(tooltip.isDisplayed()==true){
            System.out.println("Tooltip is displayed!");
        }else {
            System.out.println("Tooltip isn't displayed!");
        }
    }
}
