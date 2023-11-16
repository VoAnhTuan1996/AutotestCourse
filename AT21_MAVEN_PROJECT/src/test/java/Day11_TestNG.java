import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class Day11_TestNG {
    static WebDriver driver;
    @BeforeClass
    public void initBrowser() {
        String url = "https://demo.guru99.com/test/drag_drop.html";
        String browser = "Chrome";
        switch (browser){
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Chưa chọn browser");
                break;
        }
        driver.get(url);
        driver.manage().window().maximize();

    }

    @BeforeMethod
    public void refresh(){
        driver.navigate().refresh();
    }

    @Test()
    public void Test_TC01(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500);");
        Actions action = new Actions(driver);
        WebElement source = driver.findElement(By.xpath("//li[@id='fourth'][1]"));
        WebElement target = driver.findElement(By.xpath("//ol[@id='amt7']"));
        action.dragAndDrop(source,target).build().perform();
    }

    @Test()
    public void Test_TC02(){
        Actions action = new Actions(driver);
        WebElement source = driver.findElement(By.id("credit1"));
        WebElement target = driver.findElement(By.xpath("//ol[@id='loan']"));
        action.dragAndDrop(source,target).build().perform();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
