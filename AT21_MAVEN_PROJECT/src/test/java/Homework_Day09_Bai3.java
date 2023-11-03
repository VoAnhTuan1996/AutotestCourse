import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Homework_Day09_Bai3 {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://tiki.vn";
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
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        loginFacebook();
        Thread.sleep(8000);
        driver.quit();
    }

    public static void loginFacebook(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2600)");
        WebElement iFb = driver.findElement(By.xpath("//a[@title='Facebook']"));
        iFb.click();
        String parentIdTab = driver.getWindowHandle();
        System.out.println(parentIdTab);
        Set<String> listIdTab = driver.getWindowHandles();
        //dùng foreach duyệt qua hết tất cả các tab
        for(String item:listIdTab){
            //switch vào từng id
            driver.switchTo().window(item);
            //get ra title của từng tab
            String title = driver.getTitle();
            System.out.println(title);
            if(title.equals("Tiki | Facebook")){
                WebElement txtUsername = driver.findElement(By.xpath("//input[@type='text' and @name='email']"));
                txtUsername.sendKeys("anhtuanvo@gmail.com");
                WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password' and @id=':rq:']"));
                txtPassword.sendKeys("tuan123456");
                WebElement btnLogin = driver.findElement(By.xpath("//div[@class='x1c436fg']//child::span[text()='Đăng nhập']"));
                btnLogin.click();
                break;
            }
        }

    }
}
