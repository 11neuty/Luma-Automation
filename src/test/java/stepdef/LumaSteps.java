package stepdef;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.PageObject.LumaPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LumaSteps {
    private final WebDriver driver = Hooks.driver;
    LumaPage lumaPage = new LumaPage(driver);

    @Given("User open luma website")
    public void userVerifyStartPage(){
        Assert.assertTrue(lumaPage.verifyStartPage());
    }

    @When("User click login menu")
    public void userClickLoginMenu() {
        lumaPage.clickLoginMenu();
    }

    @And("User fill username as {string} and password as {string}")
    public void userFillUsernameAsAndPasswordAs(String uname, String pass) {
        lumaPage.fillUsername(uname);
        lumaPage.fillPassword(pass);
    }

    @And("User click login button")
    public void userClickLoginButton() {
        lumaPage.clickLoginButton();
    }

    @Then("User can login")
    public void userCanLogin() {
        lumaPage.verifyAfterLogin();
    }

    //onboarding

    @When("User click Create an account")
    public void userClickCreateAnAccount() {
    }

    @Then("Redirect to onboarding page")
    public void redirectToOnboardingPage() {
    }

    @When("Fill form data firstname as {string} lastname as {string} email as {string} password as {string} confirm pass as {string}")
    public void fillFormDataFirstnameAsLastnameAsEmailAsPasswordAsConfirmPassAsAsda(String arg0, String arg1, String arg2, String arg3) throws Throwable {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
    }

    @Then("User can see {string}")
    public void userCanSee(String arg0) {
    }}



