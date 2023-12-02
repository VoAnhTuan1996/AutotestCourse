import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class Homework_DataDrivenTesting {
    private static XSSFWorkbook excelWBook;
    private static XSSFSheet excelSheet;
    private static XSSFRow excelRow;
    private static XSSFCell excelCell;
    static WebDriver driver;
    @BeforeClass
    public void initBrowser(){
        String url = "https://demo.guru99.com/telecom/addcustomer.php";
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

    @DataProvider
    public Object[][] dataCustomer() throws IOException {
        String path = System.getProperty("user.dir");
        String filePath = path + "\\src\\test\\resources\\Customer.xlsx";
        String nameSheet = "AddNewCustomer";
        Object[][] dataCustomer = DataDrivenTesting.getTableArray(filePath,nameSheet);
        for (int i = 0; i < dataCustomer.length; i++) {
            if (dataCustomer[i][2].toString().isEmpty()) break;
            dataCustomer[i][0] = generateRandomString();
            dataCustomer[i][1] = generateRandomString();
        }
        return dataCustomer;
    }

    @Test(dataProvider = "dataCustomer")
    public void TC_Customer(String firstName, String lastName, String email, String address, String phoneNumber, String message) throws InterruptedException {
        WebElement fNameField = driver.findElement(By.xpath("//input[@id='fname']"));
        fNameField.sendKeys(firstName);
        WebElement lNameField = driver.findElement(By.xpath("//input[@id='lname']"));
        lNameField.sendKeys(lastName);
        WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
        emailField.sendKeys(email);
        WebElement addressField = driver.findElement(By.xpath("//textarea[@id='message']"));
        addressField.sendKeys(address);
        WebElement phoneNumberField = driver.findElement(By.xpath("//input[@id='telephoneno']"));
        phoneNumberField.sendKeys(phoneNumber);
        Thread.sleep(1000);
        fNameField.clear();
        lNameField.clear();
        emailField.clear();
        addressField.clear();
        phoneNumberField.clear();
        Thread.sleep(1500);
        /*WebElement btnSubmit = driver.findElement(By.xpath("//input[@type='submit']"));
        btnSubmit.click();
        WebElement messageElement = driver.findElement(By.xpath("//h1[text()='Access Details to Guru99 Telecom']"));
        String actualMessage = messageElement.getText();
        //System.out.println(actualMessage);
        // Kiểm tra thông báo thành công
        Assert.assertEquals(actualMessage, message);*/

    }

    public static String generateRandomString(){
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder fName = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(allowedChars.length());
            fName.append(allowedChars.charAt(index));
        }
        return fName.toString();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
