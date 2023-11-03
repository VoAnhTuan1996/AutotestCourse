import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Day08_AuthenticationAlert {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://demoqa.com/alerts";
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
        authenticationAlert();
        Thread.sleep(8000);
        driver.quit();
    }



    public static void authenticationAlert(){
        //truyền thẳng username và password vào link
        //https://username:password@URL
        String url = "htteps://the-internet.herokuapp.com";
        String [] lists = url.split("//");
        for(int i=0;i<lists.length;i++){
            System.out.println(lists[i]);
        }
        String username = "admin";
        String password = "admin";
        String newUrl = lists[0] + "//" + username + ":" + password + "@" + lists[1];
        driver.get(newUrl);
    }
}
