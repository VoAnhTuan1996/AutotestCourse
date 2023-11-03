import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Day08_DropdownList {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://demoqa.com/select-menu";
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
        //customDropdown();
        defaultDropdown();
        Thread.sleep(7000);
        driver.quit();
    }

    public static void customDropdown(){
        WebElement btnSelectOne = driver.findElement(By.id("selectOne"));
        btnSelectOne.click();
        WebElement btnItem = driver.findElement(By.xpath("//div[text()='Mr']"));
        btnItem.click();
    }
    public static void defaultDropdown(){
        Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
        System.out.println(select.getOptions().size());//get ra tổng số option
        System.out.println(select.isMultiple());//kiểm tra xem có được chọn nhiều hay không
        Random random = new Random();
        int index = random.nextInt(11);
        System.out.println(index);
        select.selectByIndex(index);
        //select.selectByValue("6");
        //select.selectByVisibleText("Yellow");
    }

}
