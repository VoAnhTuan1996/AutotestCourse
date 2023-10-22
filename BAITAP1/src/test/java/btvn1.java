import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
public class btvn1 {
    static WebDriver driver;//tạo ra 1 đối tượng driver tham chiếu
    public static void main(String[] agrs) throws InterruptedException {
        String url = "https://www.google.com/";
        driver = WebDriverManager.chromedriver().create();
        driver.get(url);
        Thread.sleep(3000);
        driver.manage().window().setSize(new Dimension(750,800));


        // Navigate to Tiki
        Thread.sleep(3000);
        driver.get("https://tiki.vn/");
        Thread.sleep(3000);
        driver.quit();
    }
}
