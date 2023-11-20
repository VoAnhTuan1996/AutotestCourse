import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Homework_Day10_Bai7 {
    static WebDriver driver;

    @BeforeClass
    public void initBrowser() throws InterruptedException {
        String url = "https://login.mailchimp.com/signup/";
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
        Thread.sleep(3000);
    }


    @Test
    public static void testSignupWithDifferentPasswords() throws InterruptedException {
        String email = generateRandomEmail();
        WebElement txtEmail = driver.findElement(By.id("email"));
        txtEmail.sendKeys(email);
        WebElement txtPassword = driver.findElement(By.id("new_password"));

        String password1 = generateRandomNumericPassword();
        txtPassword.sendKeys(password1);

        WebElement messageElement1 = driver.findElement(By.xpath("//span[contains(text(),'One number')]"));
        String validationMessage1 = messageElement1.getText();
        Assert.assertFalse(validationMessage1.isEmpty(),"Validation message should be displayed for password: " + password1);
        WebElement messageElement2 = driver.findElement(By.xpath("//span[contains(text(),'8 characters minimum')]"));
        String validationMessage2 = messageElement2.getText();
        Assert.assertFalse(validationMessage2.isEmpty(),"Validation message should be displayed for password: " + password1);
        Thread.sleep(3000);
        txtPassword.clear();

        String password2 = generateRandomUppercasePassword();
        txtPassword.sendKeys(password2);

        WebElement messageElement3 = driver.findElement(By.xpath("//span[contains(text(),'One uppercase character')]"));
        String validationMessage3 = messageElement3.getText();
        Assert.assertFalse(validationMessage3.isEmpty(),"Validation message should be displayed for password: " + password2);
        Thread.sleep(3000);
        txtPassword.clear();

        String password3 = generateRandomSpecialCharacterPassword();
        txtPassword.sendKeys(password3);

        WebElement messageElement4 = driver.findElement(By.xpath("//span[contains(text(),'One special character')]"));
        String validationMessage4 = messageElement4.getText();
        Assert.assertFalse(validationMessage4.isEmpty(),"Validation message should be displayed for password: " + password3);
        Thread.sleep(3000);
        txtPassword.clear();

        String password4 = generateRandomComplexPassword();
        txtPassword.sendKeys(password4);
        Assert.assertFalse(validationMessage1.isEmpty(),"Validation message should be displayed for password: " + password4);
        Assert.assertFalse(validationMessage3.isEmpty(),"Validation message should be displayed for password: " + password4);
        Assert.assertFalse(validationMessage4.isEmpty(),"Validation message should be displayed for password: " + password4);
        Thread.sleep(3000);
        txtPassword.clear();
    }

    private static String generateRandomEmail(){
        String allowedChars = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder email = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(allowedChars.length());
            email.append(allowedChars.charAt(index));
        }
        email.append("@gmail.com");
        return email.toString();
    }

    private static String generateRandomNumericPassword(){
        String allowedChars = "0123456789";
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for(int i=0; i<8;i++){
            int index = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(index));
        }
        return password.toString();
    }

    private static String generateRandomUppercasePassword(){
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for(int i=0; i<8; i++){
            int index = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(index));
        }
        return password.toString();
    }

    private static String generateRandomSpecialCharacterPassword() {
        String allowedChars = "!@#$%^&*()";
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(index));
        }
        return password.toString();
    }

    private static String generateRandomComplexPassword() {
        String allowedChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()";
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(index));
        }
        return password.toString();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        // Đóng trình duyệt
        Thread.sleep(2000);
        driver.quit();
    }
}