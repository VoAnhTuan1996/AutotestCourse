package pageFeature;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MySteps {
    @Given("Open the Firefox and launch the application")
    public void open_the_firefox_and_launch_the_application() {
        System.out.println("ABC");
    }
    @When("Enter the Username and Password")
    public void enter_the_username_and_password() {
        System.out.println("ABC");
    }
    @Then("Reset the credential")
    public void reset_the_credential() {
        System.out.println("ABC");
    }


}
