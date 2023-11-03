import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day011_Init_Browser {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface
    static String path = System.getProperty("user.dir"); //xuất ra đường dẫn hiện tại của project

    public static void main(String[] args) {
        String url = "https://tiki.vn/";
        String browser = "Chrome";
        switch (browser){
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
        // Dimension class with browser width and height value passed
        Dimension dem = new Dimension(750,450);
        // passing the Dimension object as an argument to setSize method
        driver.manage().window().setSize(dem);
        driver.quit();

    }
}
