import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Homework_Day09_Bai1 {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://dictionary.cambridge.org/vi/";
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
        loginAccountTab();
        Thread.sleep(8000);
        driver.quit();
    }

    public static void loginAccountTab(){
        WebElement spanLogin = driver.findElement(By.xpath("//span[@class=\"tb\" and text()='Đăng nhập']"));
        spanLogin.click();
        String parentIdTab = driver.getWindowHandle();
        System.out.println(parentIdTab);
        //get ra tất cả các tab/window đang có
        Set<String> listIdTab = driver.getWindowHandles();
        //dùng foreach duyệt qua hết tất cả các tab
        for(String item:listIdTab){
            //switch vào từng id
            driver.switchTo().window(item);
            //get ra title của từng tab
            String title = driver.getTitle();
            System.out.println(title);
            if(title.equals("Login")){
                WebElement btnLogin = driver.findElement(By.xpath("//body/div[@id='login']/div[@id='login_content']/div[@id='gigya-login-screen']/form[@id='gigya-login-form']/div[2]/div[3]/div[5]/input[1]"));
                btnLogin.click();
                //verify
                WebElement emailField = driver.findElement(By.xpath("//body/div[@id='login']/div[@id='login_content']/div[@id='gigya-login-screen']/form[@id='gigya-login-form']/div[2]/div[3]/div[1]/input[1]"));
                WebElement passwordField = driver.findElement(By.xpath("//body/div[@id='login']/div[@id='login_content']/div[@id='gigya-login-screen']/form[@id='gigya-login-form']/div[2]/div[3]/div[2]/input[1]"));
                System.out.println(emailField.isDisplayed());
                System.out.println(passwordField.isDisplayed());

               if(emailField.isDisplayed()==true && passwordField.isDisplayed()==true){
                    System.out.println("Message 'This field is required' is displayed for both Username and Password fields");
                }else {
                    System.out.println("Verification failed");
                }
            }
        }
        driver.switchTo().window(parentIdTab);
        System.out.println(driver.getCurrentUrl());
        if (driver.getCurrentUrl().equals("https://dictionary.cambridge.org/vi/") || driver.getTitle().equals("Cambridge Dictionary | Từ điển tiếng Anh, Bản dịch & Từ điển từ đồng nghĩa")) {
            System.out.println("Returned to the parent window");
        } else {
            System.out.println("Verification failed");
        }
    }

}
