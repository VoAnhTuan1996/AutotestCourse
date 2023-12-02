import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Day11_DataDrivenTesting {
    private static XSSFWorkbook excelWBook;
    private static XSSFSheet excelSheet;
    private static XSSFRow excelRow;
    private static XSSFCell excelCell;
    static WebDriver driver;
    @BeforeClass
    public void initBrowser(){
        String url = "https://www.facebook.com";
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
        driver.get(url);
        driver.manage().window().maximize();
    }

   /* @DataProvider
    public Object[][] dataLogin() throws IOException {
        String path = System.getProperty("user.dir");
        String filePath = path + "\\src\\test\\resources\\TC_Login.xlsx";
        String nameSheet = "Login";
        Object[][] dataLogin = DataDrivenTesting.getTableArray(filePath,nameSheet);
        return dataLogin;
    }*/
    @Test(dataProviderClass = DataDrivenTesting.class, dataProvider = "TC_Login123")
    public void TC_Login(String email, String password) throws InterruptedException {
        WebElement txtEmail = driver.findElement(By.xpath("//input[@name='email']"));
        txtEmail.sendKeys(email);
        WebElement txtPassword = driver.findElement(By.xpath("//input[@name='pass']"));
        txtPassword.sendKeys(password);
        WebElement btnSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
        btnSubmit.click();
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
