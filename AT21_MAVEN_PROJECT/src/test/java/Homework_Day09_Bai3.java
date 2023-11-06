import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Homework_Day09_Bai3 {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
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
        loginFacebook();
        Thread.sleep(15000);
        driver.quit();
    }

    public static void loginFacebook() throws InterruptedException {
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//a[text()='Xem thêm']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(5000);

        WebElement iFb = driver.findElement(By.xpath("//a[@title='Facebook']"));
        iFb.click();

        String parentIdTab = driver.getWindowHandle();
        System.out.println(parentIdTab);
        Set<String> listIdTab = driver.getWindowHandles();
        //dùng foreach duyệt qua hết tất cả các tab
        for (String item : listIdTab) {
            //switch vào từng id
            driver.switchTo().window(item);
            //get ra title của từng tab
            String title = driver.getTitle();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(title);
            if (title.equals("Tiki | Facebook")) {
                Thread.sleep(3000);
                WebElement clickTruoc = driver.findElement(By.xpath("//span[contains(text(),'Email address or phone number')]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickTruoc);
                WebElement txtUsername = driver.findElement(By.xpath("//input[@type='text' and @name='email']"));
                txtUsername.sendKeys("anhtuanvo@gmail.com");
                Thread.sleep(3000);
//
                WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password' and @name = 'pass' and @aria-invalid]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", txtPassword);
                txtPassword.sendKeys("tuan123456");
                WebElement btnLogin = driver.findElement(By.xpath("(//div[@role='button' and @aria-label='Accessible login button'])[2]"));
                btnLogin.click();
                break;
            }
        }
    }
}