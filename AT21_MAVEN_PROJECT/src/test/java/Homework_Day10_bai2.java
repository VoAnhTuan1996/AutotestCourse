import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Homework_Day10_bai2 {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://shopee.vn/buyer/login";
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
        loginGoogle();
        Thread.sleep(7000);
        driver.quit();
    }

    public static void loginGoogle() throws InterruptedException {
        WebElement btnLogin = driver.findElement(By.xpath("//div[text()='Google']//parent::button"));
        btnLogin.click();
        String parentIdTab = driver.getWindowHandle();
        System.out.println(parentIdTab);
        //get ra tất cả các tab/window đang có
        Set<String> listIdTab = driver.getWindowHandles();
        //System.out.println(listIdTab.size());
        for(String item:listIdTab) {
            //switch vào từng id
            driver.switchTo().window(item);
            //get ra title của từng tab
            String title = driver.getTitle();
            System.out.println(title);
            Thread.sleep(5000);
            if(title.equals("Đăng nhập - Tài khoản Google")){
                WebElement btnContinue = driver.findElement(By.xpath("//span[text()='Tiếp theo']//parent::button"));
                btnContinue.click();
                WebElement errText = driver.findElement(By.xpath("//div[@class='o6cuMc Jj6Lae']"));
                if(errText.isDisplayed()==true){
                    System.out.println("Verify passed");
                }
                else {
                    System.out.println("Verify failed");
                }
            }
        }
        System.out.println(driver.getCurrentUrl());
    }
}
