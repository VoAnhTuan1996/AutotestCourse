package pages.Obj;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
    WebDriver driver;

    @FindBy(name = "txtUsername")
    WebElement userName;

    @FindBy(name = "txtPassword")
    WebElement password;

    @FindBy(id = "logInPanelHeading")
    WebElement titleText;

    @FindBy(id = "btnLogin")
    WebElement login;

    @FindBy(id="spanMessage")
    WebElement errorMessage;

    @FindBy(id="forgotPasswordLink")
    WebElement forgetPasswordLink;

    @FindBy(xpath="//*[@id='social-icons']/a[1]/img")
    WebElement linkedInIcon;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        // This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    // Set user name in textbox
    public void setUserName(String strUserName) {
        userName.sendKeys(strUserName);
    }

    // Set password in password textbox
    public void setPassword(String strPassword) {
        password.sendKeys(strPassword);
    }

    // Click on login button
    public void clickLogin() {
        login.click();
    }

    // Get the title of Login Page
    public String getLoginTitle() {
        return titleText.getText();
    }

    // Get the text of forgotPasswordLink
    public String getforgotPasswordLinkText() {
        return forgetPasswordLink.getText();
    }

    // Get the errorMessage
    public String getErrorMessage() {
        return errorMessage.getText();
    }

    // Verify linkedInIcon is enabled
    public Boolean isEnabledLinkedIn() {
        return linkedInIcon.isEnabled();
    }

    public void login(String strUserName, String strPasword) {

        // Fill user name
        this.setUserName(strUserName);

        // Fill password
        this.setPassword(strPasword);

        // Click Login button
        this.clickLogin();
    }
}
