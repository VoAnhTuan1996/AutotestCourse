import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Homework_Day08_bai1 {
    static WebDriver driver; //tạo ta 1 đối tượng driver tham chiếu tới WebDriver interface

    public static void main(String[] args) throws InterruptedException {
        String url = "https://files.fm/";
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
        uploadFile();
        Thread.sleep(7000);
        driver.quit();
    }

    public static void uploadFile() {
        String path = System.getProperty("user.dir");
        String imgFile = path + "\\src\\test\\resources\\images.jpg";
        System.out.printf(imgFile);
        WebElement fileInput = driver.findElement(By.xpath("(//input[@type='file'])[2]"));
        System.out.println(fileInput.getText());
        fileInput.sendKeys(imgFile);

       /* try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Kiểm tra xem file đã được tải lên thành công hay chưa
        WebElement uploadedFile = driver.findElement(By.xpath("//div[@id='uploaded-files']"));
        String uploadedFileName = uploadedFile.getText();

        if (uploadedFileName.equals("your_file_name")) {
            System.out.println("File has been uploaded successfully.");
        } else {
            System.out.println("File upload failed.");
        }*/
    }

}
