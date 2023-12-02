package test;

import core.BaseTest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Obj.AddCustomerPageObj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static core.BasePage.*;

public class TC_AddCustomer extends BaseTest{
    private Workbook workbook;
    private Sheet sheet;

    AddCustomerPageObj objAddCustomer;
    @BeforeMethod
    public void openUrl(){
        String url = BaseUrl + "telecom/addcustomer.php";
        driver.get(url);
        objAddCustomer = new AddCustomerPageObj(driver);
    }
    @DataProvider(name = "CustomerData")
    public Object[][] dataCustomer() throws IOException {
        String path = System.getProperty("user.dir");
        String filePath = path + "\\src\\test\\resources\\Customer.xlsx";
        String nameSheet = "AddNewCustomer";

        FileInputStream file = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(nameSheet);

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            data[i][1] = generateRandomString();
            data[i][2] = generateRandomString();
            Row row = sheet.getRow(i + 1);
            for (int j = 0; j < colCount; j++) {
                if (j == 1 || j == 2) continue;
                Cell cell = row.getCell(j);
                DataFormatter formatter = new DataFormatter();
                String cellValue = formatter.formatCellValue(cell);
                data[i][j] = cellValue;
            }
        }
        return data;
    }

    @Test(dataProvider="CustomerData")
     public void addCustomerTest(String id, String firstName, String lastName, String email, String address, String phoneNumber, String message) throws InterruptedException {
        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='fname']"));
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='lname']"));
        WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement addressField = driver.findElement(By.xpath("//textarea[@id='message']"));
        WebElement phoneNumberField = driver.findElement(By.xpath("//input[@id='telephoneno']"));
        WebElement errorMessageFname = driver.findElement(By.id("message"));
        WebElement errorMessageLname = driver.findElement(By.id("message50"));
        WebElement errorMessageEmail = driver.findElement(By.id("message9"));
        WebElement errorMessageAddress = driver.findElement(By.id("message3"));
        WebElement errorMessagePhone = driver.findElement(By.id("message7"));
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        addressField.sendKeys(address);
        phoneNumberField.sendKeys(phoneNumber);
        phoneNumberField.sendKeys("\t"); // hêre
        if(firstName.isEmpty()){
            message = errorMessageFname.getText();
            System.out.println(message);
            Assert.assertEquals(message,"Customer name must not be blank");
        } else if (lastName.isEmpty()) {
            message = errorMessageLname.getText();
            System.out.println(message);
            Assert.assertEquals(message,"Customer name must not be blank");
        } else if (email.isEmpty()) {
            message = errorMessageEmail.getText();
            System.out.println(message);
            Assert.assertEquals(message,"Email-ID must not be blank");
        } else if (!isValidEmail(email)) {
            message = errorMessageEmail.getText();
            System.out.println(message);
            Assert.assertEquals(message,"Email-ID is not valid");
        } else if (address.isEmpty()) {
            message = errorMessageAddress.getText();
            System.out.println(message);
            Assert.assertEquals(message,"Address Field must not be blank");
        } else if (hasAlphabeticCharacters(phoneNumber)) {
            message = errorMessagePhone.getText();
            System.out.println(message);
            Assert.assertEquals(message,"Characters are not allowed");
        } else if (phoneNumber.isEmpty()) {
            message = errorMessagePhone.getText();
            System.out.println(message);
            Assert.assertEquals(message,"Mobile no must not be blank");
        }

        Thread.sleep(3000);

        // Perform further actions or assertions on the added customer

        // Clear the fields
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        addressField.clear();
        phoneNumberField.clear();
    }
}
