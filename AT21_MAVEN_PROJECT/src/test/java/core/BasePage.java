package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;

public class BasePage {
    private long TIMEOUT = 30;
    private WebDriverWait wait;
    private Actions actions;
    public By getByXpath(String locator){
        return By.xpath(locator);
    }

    public WebElement getElementByXpath(WebDriver driver, String locator){
        return driver.findElement(getByXpath(locator));
    }

    public void clickToElement(WebDriver driver, String locator){
        getElementByXpath(driver,locator).click();
    }

    public void sendKeyToElementByXpath(WebDriver driver, String locator, String text){
        getElementByXpath(driver,locator).sendKeys(text);
    }

    public void waitForElementVisible(WebDriver driver, String locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public void doubleClickToElement(WebDriver driver, String locator){
        actions = new Actions(driver);
        actions.doubleClick(getElementByXpath(driver,locator)).build().perform();
    }

    public static String generateRandomEmail(){
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

    public static String generatePhoneNumber(){
        String allowedChars = "0123456789";
        StringBuilder phone = new StringBuilder();
        Random random = new Random();
        phone.append(0);
        for(int i=1;i<10;i++){
            int index = random.nextInt(allowedChars.length());
            phone.append(allowedChars.charAt(index));
        }
        return phone.toString();
    }

    public static void randomDropdownList(List<WebElement> itemTitle){
        Random random = new Random();
        int randomIndex = random.nextInt(itemTitle.size());
        WebElement randomItemTitle = itemTitle.get(randomIndex);
        randomItemTitle.click();
        System.out.println(randomItemTitle.getText());
    }

    public static void randomYear(List<WebElement> year){
        Random random = new Random();
        int randomIndex = random.nextInt(year.size());
        WebElement randomYearItem = year.get(randomIndex);
        randomYearItem.click();
    }

    public static void randomMonth(List<WebElement> month){
        Random random = new Random();
        int randomIndex = random.nextInt(month.size());
        WebElement randomMonthItem = month.get(randomIndex);
        randomMonthItem.click();
    }

    public static void randomDay(List<WebElement> day){
        Random random = new Random();
        int randomIndex = random.nextInt(day.size());
        WebElement randomDayItem = day.get(randomIndex);
        randomDayItem.click();
    }

    public static void randomLicencePeriod(List<WebElement> lP){
        Random random = new Random();
        int randomIndex = random.nextInt(lP.size());
        WebElement randomDayItem = lP.get(randomIndex);
        randomDayItem.click();
    }

    public static void randomOccupation(List<WebElement> o){
        Random random = new Random();
        int randomIndex = random.nextInt(o.size());
        WebElement randomDayItem = o.get(randomIndex);
        randomDayItem.click();
    }

    public static String randomPassword(){
        String allowedChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()";
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(index));
        }
        return password.toString();
    }

    public static String generateRandomString(){
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder fName = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(allowedChars.length());
            fName.append(allowedChars.charAt(index));
        }
        return fName.toString();
    }

    public static boolean hasAlphabeticCharacters(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }

}
