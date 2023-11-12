import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Homework_Day10_bai3 {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://www.fahasa.com/customer/account/create";
        String browser = "Firefox";
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
        loginFahasa();
        Thread.sleep(7000);
        driver.quit();
    }

    public static void loginFahasa(){
        WebElement tabLogin = driver.findElement(By.xpath("//a[text()='Đăng nhập']//parent::li"));
        tabLogin.click();
        WebElement btnLogin = driver.findElement(By.xpath("//button[@title='Đăng nhập' and @class='fhs-btn-login']"));
        boolean isDisabled = Boolean.parseBoolean(btnLogin.getAttribute("disabled"));
        String backgroundColor = btnLogin.getCssValue("background-color");
        // Verify button "Đăng nhập" là disable
        if (isDisabled) {
            System.out.println("Button 'Đăng nhập' là disable");
        } else {
            System.out.println("Button 'Đăng nhập' không phải là disable");
        }

        // Verify button "Đăng nhập" có background color là màu xám
        if (backgroundColor.equals("rgba(128, 128, 128, 1)")) {
            System.out.println("Button 'Đăng nhập' có background color là màu xám");
        } else {
            System.out.println("Button 'Đăng nhập' không có background color là màu xám");
        }

    }
}
