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
        lumaPage.clickCreateAccount();
    }

    @Then("Redirect to onboarding page")
    public void redirectToOnboardingPage() {
        lumaPage.verifyOnboardingPage();
    }

    @When("Fill form data firstname as {string} lastname as {string} email as {string} password as {string} confirm pass as {string}")
    public void fillFormDataFirstnameAsLastnameAsEmailAsPasswordAsConfirmPassAsAsda(String firstName, String lastName, String email, String pass, String confirmPass) throws Throwable {
        lumaPage.fillForm(firstName, lastName, email, pass, confirmPass);
        lumaPage.clickCreateAnAccount();
    }

    @Then("User can see {string}")
    public void userCanSee(String ecpectedText) {
        lumaPage.verifyCreateAccount(ecpectedText);
    }

    @Then("Error validation has appear")
    public void errorValidationHasAppear() {
        lumaPage.verifyErrorLogin();

    }

    @Then("Error email validation has appear")
    public void errorEmailValidationHahsAppear() {
        lumaPage.verifyEmailError();

    }


    @When("User add to cart item")
    public void userAddToCartItem() {
        lumaPage.addToCartItem();
    }

    @And("User check cart")
    public void userCheckCart() {
        lumaPage.checkCart();
    }

    @Then("Added item shown")
    public void addedItemShown() {
        lumaPage.checkItem();
    }

    @When("User search item {string}")
    public void userSearchItem(String item) {
        lumaPage.searchItem(item);
    }


    @Then("Search result has shown {string}")
    public void searchResultHasShown(String item) {
        lumaPage.verifySearchItem(item);
    }

    @When("User choose item")
    public void userChooseItem() {
    }

    @And("User click add to wishlist")
    public void userClickAddToWishlist() {
    }

    @Then("Item shown on my wishlist")
    public void itemShownOnMyWishlist() {
    }
}



