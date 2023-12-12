package test;
import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Obj.RegisterPage_Obj;
import java.util.List;

import javax.swing.text.html.Option;
import java.util.Random;

import static core.BasePage.*;

public class TC_Register extends BaseTest{
    RegisterPage_Obj objRegister;

    @BeforeMethod
    public void openUrl(){
        String url = BaseUrl + "insurance/v1/register.php";
        driver.get(url);
        objRegister = new RegisterPage_Obj(driver);
    }

    //@Test
    public void TC_clickDropdownTitle() throws InterruptedException {
        WebElement slTitle = driver.findElement(By.xpath("//select[@id='user_title']"));
        slTitle.click();
        //Lấy danh sách phần tử trong dropdown list
        Select select = new Select(slTitle);
        List<WebElement> itemTitle = select.getOptions();
        // Chọn ngẫu nhiên một phần tử trong dropdown
        randomDropdownList(itemTitle);
        Thread.sleep(3000);
    }

    //@Test
    public void TC_Register01() throws InterruptedException {
        objRegister.enterToFirstNameTxt("Hoang");
        objRegister.enterToSurNameTxt("Van Minh");
        objRegister.enterToPhoneNumber(generatePhoneNumber());
        objRegister.enterToAddressStreet("Nguyen Hue");
        objRegister.enterToCity("Ho Chi Minh");
        objRegister.enterToCountry("VietNam");
        Thread.sleep(3000);
    }

    //@Test
    public void TC_enterEmail() throws InterruptedException {
        String email = generateRandomEmail();
        WebElement txtEmail = driver.findElement(By.xpath("//input[@id='user_user_detail_attributes_email']"));
        txtEmail.sendKeys(email);
        Thread.sleep(3000);
    }

    //@Test
    public void TC_clickDropdownDateOfBirth() throws InterruptedException {
        //select year
        WebElement year = driver.findElement(By.id("user_dateofbirth_1i"));
        year.click();
        Select select1 = new Select(year);
        List<WebElement> itemYear = select1.getOptions();
        randomYear(itemYear);
        Thread.sleep(1000);
        //select month
        WebElement month = driver.findElement(By.id("user_dateofbirth_2i"));
        month.click();
        Select select2 = new Select(month);
        List<WebElement> itemMonth = select2.getOptions();
        randomMonth(itemMonth);
        Thread.sleep(1000);
        //select day
        WebElement day = driver.findElement(By.id("user_dateofbirth_3i"));
        day.click();
        Select select3 = new Select(day);
        List<WebElement> itemDay = select3.getOptions();
        randomDay(itemDay);
        Thread.sleep(3000);
    }

    //@Test
    public void TC_clickDropdownLicensePeriod() throws InterruptedException {
        WebElement lPeriodElement = driver.findElement(By.id("user_licenceperiod"));
        lPeriodElement.click();
        Select select = new Select(lPeriodElement);
        List<WebElement> items = select.getOptions();
        randomLicencePeriod(items);
        Thread.sleep(3000);
    }

    //@Test
    public void TC_clickDropdownOccupation() throws InterruptedException{
        WebElement occupationElement = driver.findElement(By.id("user_occupation_id"));
        occupationElement.click();
        Select select = new Select(occupationElement);
        List<WebElement> items = select.getOptions();
        randomOccupation(items);
        Thread.sleep(3000);
    }

    //@Test
    public void TC_enterPassword() throws InterruptedException {
        String pass = randomPassword();
        WebElement passElement = driver.findElement(By.id("user_user_detail_attributes_password"));
        passElement.sendKeys(pass);
        System.out.println(pass);
        WebElement confirmPass = driver.findElement(By.id("user_user_detail_attributes_password_confirmation"));
        confirmPass.sendKeys(pass);
        Thread.sleep(3000);

    }

    //@Test
    public void TC_clickButtonReset(){
        WebElement btnReset = driver.findElement(By.id("resetform"));
        btnReset.click();
    }

    //@Test
    public void TC_clickButtonCreate(){
        WebElement btnCreate = driver.findElement(By.xpath("//input[@value='Create']"));
        btnCreate.click();
    }

}
