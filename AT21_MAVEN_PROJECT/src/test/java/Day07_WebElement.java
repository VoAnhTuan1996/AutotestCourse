import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Day07_WebElement {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://tiki.vn/";
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
        clickLinkProduct();
        //searchProduct();
        Thread.sleep(8000);
        driver.quit();
    }

    public static  void clickLinkProduct(){
        WebElement aLinkProduct = driver.findElement(By.linkText("sách"));
        aLinkProduct.click();
        System.out.println(aLinkProduct.isEnabled());
        WebElement btnMeat = driver.findElement(By.partialLinkText("thịt"));
        btnMeat.click();
    }


    public static void searchProduct(){
            WebElement txtSearch = driver.findElement(By.xpath("//input[@data-view-id='main_search_form_input']"));
            txtSearch.sendKeys("sữa tươi không đường");
            txtSearch.sendKeys("thịt");
            WebElement btnSearch = driver.findElement(By.xpath("//button[text()='Tìm kiếm']"));
            btnSearch.click();
            System.out.println("title: "+driver.getTitle());
            System.out.println("currentUrl: "+driver.getCurrentUrl());
    }

}
