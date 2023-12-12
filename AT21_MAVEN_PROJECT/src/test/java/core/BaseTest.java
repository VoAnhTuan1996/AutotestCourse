package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public static WebDriver driver;
    public String BaseUrl = "https://demo.guru99.com/";
    @BeforeClass
    public void initBrowser(){
        String browser = "Chrome";
        switch (browser){
            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--lang=vi");
                driver = WebDriverManager.chromedriver().capabilities(options).create();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Chưa chọn browser");
                break;
        }

        driver.manage().window().maximize();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
