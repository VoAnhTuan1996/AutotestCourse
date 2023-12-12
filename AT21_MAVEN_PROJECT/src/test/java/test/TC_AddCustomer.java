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
import pages.UI.AddCustomerUI;

import java.io.FileInputStream;
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
        objAddCustomer.enterFirstNameTxt(firstName);
        objAddCustomer.enterLastNameTxt(lastName);
        objAddCustomer.enterEmailTxt(email);
        objAddCustomer.enterAddressTextArea(address);
        objAddCustomer.enterPhoneNumber(phoneNumber);
        objAddCustomer.enterPhoneNumber("\t");
        WebElement errorMessageFname = objAddCustomer.getElementById(driver, AddCustomerUI.MESSAGE_FNAME);
        WebElement errorMessageLname = objAddCustomer.getElementById(driver, AddCustomerUI.MESSAGE_LNAME);
        WebElement errorMessageEmail = objAddCustomer.getElementById(driver, AddCustomerUI.MESSAGE_EMAIL);
        WebElement errorMessageAddress = objAddCustomer.getElementById(driver, AddCustomerUI.MESSAGE_ADDRESS);
        WebElement errorMessagePhone = objAddCustomer.getElementById(driver, AddCustomerUI.MESSAGE_PHONE);

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

    }
}
