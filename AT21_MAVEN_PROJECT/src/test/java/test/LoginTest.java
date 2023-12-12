package test;
import static org.testng.Assert.assertTrue;
import core.BaseTests;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pages.Obj.LoginPage;

public class LoginTest extends BaseTests {

    LoginPage objLogin;

    @Test(priority = 0)
    public void verifyLoginPageTitle() {

        // Create Login Page object
        objLogin = new LoginPage(driver);

        // Verify login page text
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("LOGIN Panel"));
    }

    @Test(priority = 1)
    public void verifyforgetPasswordLink() {

        String expectedText= objLogin.getforgotPasswordLinkText();
        Assert.assertTrue(expectedText.contains("Forgot your password?"));

    }

    @Test(priority = 2)
    public void HomeTest() {

        // login to application
        objLogin.login("Admin1", "admin1234");

        String expectedError = objLogin.getErrorMessage();

        // Verify home page
        Assert.assertTrue(expectedError.contains("Username cannot be empty"));
    }

    @Test(priority = 3)
    public void verifyLinkedIn() {

        System.out.println("Actual linkedIn Text :" + objLogin.isEnabledLinkedIn());
        assertTrue(objLogin.isEnabledLinkedIn());

        System.out.println("Im in skip exception");
        throw new SkipException("Skipping this exception");
    }

}