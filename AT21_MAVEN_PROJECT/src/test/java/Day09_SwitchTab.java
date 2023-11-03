import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Day09_SwitchTab {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://demoqa.com/browser-windows";
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
        switchToTab();
        Thread.sleep(8000);
        driver.quit();
    }

    public static void switchToTab(){
        WebElement btnTabButton = driver.findElement(By.id("tabButton"));
        btnTabButton.click();
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
            if(title.equals("")){
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println(text.getText());
                break;
            }
        }
    }

}
