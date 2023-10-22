import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day01_Init_Browser {
    static WebDriver driver;//tạo ra 1 đối tượng driver tham chiếu
    static String path = System.getProperty("user.dir");//xuất ra đường dẫn hiện tại của project

    public static void main(String[] agrs) throws InterruptedException {
        String url = "https://about.gitlab.com/";
        String browser = "Firefox";
        switch (browser){
            case "Chrome":
                WebDriverManager.chromedriver().create();
                driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().create();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.print("Chưa chọn browser");
                break;
        }
        driver.get(url);
        // Dimension class with browser width and height value passed
        Dimension dem = new Dimension(750,450);
        // passing the Dimension object as an argument to setSize method
        driver.manage().window().setSize(dem);
        Thread.sleep(3000);
        driver.quit();
    }
}
