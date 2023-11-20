import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Homework_Day10_Bai6 {
    static WebDriver driver;

    @BeforeClass
    public void initBrowser() throws InterruptedException {
        String url = "https://jqueryui.com/selectable/";
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
        Thread.sleep(3000);
    }


    @Test
    public static void testSelectable(){
        WebElement listFrame = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(listFrame);
        WebElement item1 = driver.findElement(By.xpath("//ol[@id='selectable']//li[1]"));
        WebElement item5 = driver.findElement(By.xpath("//ol[@id='selectable']//li[5]"));
        Actions builder = new Actions(driver);
        builder.clickAndHold(item1).moveToElement(item5).release().perform();
        //kiểm tra
        List<WebElement> selectedItems = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class, 'ui-selected')]"));
        Assert.assertEquals(selectedItems.size(),5);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        // Đóng trình duyệt
        Thread.sleep(2000);
        driver.quit();
    }
}