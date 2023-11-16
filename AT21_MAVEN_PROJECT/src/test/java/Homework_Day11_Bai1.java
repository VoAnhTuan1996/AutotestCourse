import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Homework_Day11_Bai1 {
    static WebDriver driver;

    @BeforeClass
    public void initBrowser() throws InterruptedException {
        String url = "https://tiki.vn/";
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
    }

    //    @Test
    public static void test01() throws InterruptedException {
        WebElement txtSearch = driver.findElement(By.xpath("//input[@data-view-id=\"main_search_form_input\"]"));
        txtSearch.sendKeys("laptop");
        WebElement btnSearch = driver.findElement(By.xpath("//button[@data-view-id='main_search_form_button']"));
        btnSearch.click();
        //không lấy element kiểểu này nhá, c nhắc nhiều lần r mà
        WebElement fItem = driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/main[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]"));
        fItem.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Thông tin chi tiết')]"));
        js.executeScript("window.scroll(0,1700);");
        Thread.sleep(5000);
        WebElement brandElement = driver.findElement(By.xpath("//span[contains(text(),'Thương hiệu')]"));
        String brand = brandElement.getText();
        WebElement brandOriginElement = driver.findElement(By.xpath("//span[contains(text(),'Xuất xứ thương hiệu')]"));
        String brandOrigin = brandOriginElement.getText();
        WebElement originElement = driver.findElement(By.xpath("//span[text()='Xuất xứ']"));
        String origin = originElement.getText();
        // Kiểm tra thông tin sản phẩm
        Assert.assertEquals(brand, "Thương hiệu");
        Assert.assertEquals(brandOrigin, "Xuất xứ thương hiệu");
        Assert.assertEquals(origin, "Xuất xứ");
    }

    @Test
    public static void test02() throws InterruptedException {
        WebElement txtSearch = driver.findElement(By.xpath("//input[@data-view-id=\"main_search_form_input\"]"));
        txtSearch.sendKeys("sữa tươi không đường");
        WebElement btnSearch = driver.findElement(By.xpath("//button[@data-view-id='main_search_form_button']"));
        btnSearch.click();
        WebElement sItem = driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/main[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/a[1]/span[1]/div[1]/div[1]/picture[1]/img[1]"));
        sItem.click();
//        WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Thông tin chi tiết')]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(3000);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,1600)");
        WebElement brandElement = driver.findElement(By.xpath("//span[contains(text(),'Thương hiệu')]"));
        String brand = brandElement.getText();
        WebElement brandOriginElement = driver.findElement(By.xpath("//span[contains(text(),'Xuất xứ thương hiệu')]"));
        String brandOrigin = brandOriginElement.getText();
        WebElement originElement = driver.findElement(By.xpath("//span[text()='Xuất xứ']"));
        String origin = originElement.getText();
        WebElement hsdElement = driver.findElement(By.xpath("//span[text()='Hạn sử dụng']"));
        String hsd = hsdElement.getText();
        // Kiểm tra thông tin sản phẩm
        Assert.assertEquals(brand, "Thương hiệu");
        Assert.assertEquals(brandOrigin, "Xuất xứ thương hiệu");
        Assert.assertEquals(origin, "Xuất xứ");
        Assert.assertEquals(hsd,"Hạn sử dụng");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        // Đóng trình duyệt
        Thread.sleep(5000);
        driver.quit();
    }
}