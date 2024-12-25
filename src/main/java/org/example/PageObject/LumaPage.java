package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import java.util.Objects;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class LumaPage {
    private WebDriver webDriver;
    private static final Logger logger = Logger.getLogger(LumaPage.class.getName());

    public LumaPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private <T> T executeWithHandling(Callable<T> callable) {
        try {
            return callable.call();
        } catch (NoSuchElementException e) {
            logger.warning("Element not found: " + e.getMessage());
            return null; // Atau nilai default yang sesuai
        } catch (StaleElementReferenceException e) {
            logger.warning("Stale element reference: " + e.getMessage());
            return null; // Atau nilai default yang sesuai
        } catch (ElementClickInterceptedException e) {
            logger.warning("Element click intercepted: " + e.getMessage());
            return null; // Atau nilai default yang sesuai
        } catch (Exception e) {
            logger.severe("An unexpected error occurred: " + e.getMessage());
            return null; // Atau nilai default yang sesuai
        }
    }

    public boolean verifyStartPage() {
        WebElement verifyStart = waitForElement(By.xpath("//div/ul/li/a[contains(text(), 'Sign In')]"));
        return verifyStart.isDisplayed();
    }

    public void clickLoginMenu() {
        executeWithHandling(() -> {
            WebElement loginMenu = waitForElement(By.xpath("//div/ul/li/a[contains(text(), 'Sign In')]"));
            loginMenu.click();
            return null;
        });
    }

    public void fillUsername(String uname) {
        executeWithHandling(() -> {
            WebElement fillUname = waitForElement(By.xpath("//div/input[@id='email']"));
            fillUname.sendKeys(uname);
            return null;
        });
    }

    public void fillPassword(String pass) {
        executeWithHandling(() -> {
            WebElement fillPass = waitForElement(By.xpath("//div/input[@title='Password']"));
            fillPass.sendKeys(pass);
            return null;
        });
    }

    public void clickLoginButton() {
        executeWithHandling(() -> {
            WebElement clickLogin = waitForElement(By.xpath("//div/div/button[@type='submit' and @class='action login primary']"));
            clickLogin.click();
            return null;
        });
    }

    public boolean verifyAfterLogin() {
        return executeWithHandling(() -> {
            WebElement verifyAfterLogin = waitForElement(By.xpath("//h1/span[text()='Home Page']"));
            return verifyAfterLogin.isDisplayed();
        }) != null;
    }

    public void clickCreateAccount() {
        executeWithHandling(() -> {
            WebElement clickCreateAcc = waitForElement(By.xpath("//div[@class='panel header']//a[.='Create an Account']"));
            clickCreateAcc.click();
            return null;
        });
    }

    public boolean verifyOnboardingPage() {
        return executeWithHandling(() -> {
            WebElement verifOnboarding = waitForElement(By.xpath("//h1/span[text()='Create New Customer Account']"));
            return verifOnboarding.isDisplayed();
        }) != null;
    }

    public void fillForm(String firstName, String lastName, String email, String pass, String confirmPass) {
        executeWithHandling(() -> {
            WebElement firstNameField = waitForElement(By.xpath("//div/input[@name='firstname']"));
            firstNameField.sendKeys(firstName);

            WebElement fillLastName = waitForElement(By.xpath("//div/input[@name='lastname']"));
            fillLastName.sendKeys(lastName);

            WebElement fillEmail = waitForElement(By.xpath("//div/input[@name='email']"));
            fillEmail.sendKeys(email);

            WebElement fillPass = waitForElement(By.xpath("// div/input[@title='Password']"));
            fillPass.sendKeys(pass);

            WebElement fillConfirmPass = waitForElement(By.xpath("//div/input[@title='Confirm Password']"));
            fillConfirmPass.sendKeys(confirmPass);
            return null;
        });
    }

    public void clickCreateAnAccount() {
        executeWithHandling(() -> {
            WebElement clickCreateAnAccount = waitForElement(By.xpath("//div/button/span[text()='Create an Account']"));
            clickCreateAnAccount.click();
            return null;
        });
    }

    public boolean verifyCreateAccount(String expectedText) {
        return executeWithHandling(() -> {
            WebElement verifCreateAcc = waitForElement(By.xpath("//div[.='Thank you for registering with Main Website Store.']"));
            String actualText = verifCreateAcc.getText();

            if (!expectedText.equals(actualText)) {
                return false;
            }

            WebElement myAcc = waitForElement(By.xpath("//h1/span[text()='My Account']"));
            return myAcc.isDisplayed();
        }) != null;
    }

    public boolean verifyErrorLogin() {
        return executeWithHandling(() -> {
            WebElement errorLogin = waitForElement(By.xpath("//div[@class='message-error error message']/div[contains(.,'The account')]"));
            return errorLogin.isDisplayed();
        }) != null;
    }

    public boolean verifyEmailError() {
        return executeWithHandling(() -> {
            WebElement emailError = waitForElement(By.xpath("//div/div[contains(text(), 'Please enter a valid email address')]"));
            return emailError.isDisplayed();
        }) != null;
    }

    public void addToCartItem() {
        executeWithHandling(() -> {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("window.scrollBy(0, 500);");

            WebElement addSize = waitForElement(By.xpath("//div[@class='swatch-opt-1556']//div[.='S']"));
            addSize.click();

            WebElement addColor = waitForElement(By.xpath("//div[@class='swatch-opt-1556']/div[@class='swatch-attribute color']//div[2]"));
            addColor.click();

            WebElement clickAddToCart = waitForElement(By.xpath("//div/div/div/form/button[@title='Add to Cart']"));
            clickAddToCart.click();
            return null;
        });
    }

    public void checkCart() {
        executeWithHandling(() -> {
            WebElement checkCart = waitForElement(By.xpath("//div/a[@class='action showcart']"));
            checkCart.click();
            return null;
        });
    }

    public boolean checkItem() {
        return executeWithHandling(() -> {
            WebElement checkNameItem = waitForElement(By.xpath("//ol[@class='product-items widget-product-grid']//strong[contains(.,'Radiant Tee')]"));
            String itemName = checkNameItem.getText();

            checkCart();

            WebElement checkNameCart = waitForElement(By.xpath("//a[.='Radiant Tee']"));
            String cartItemName = checkNameCart.getText();

            return cartItemName.equals(itemName);
        }) != null;
    }

    public void searchItem(String item) {
        executeWithHandling(() -> {
            WebElement searchItem = waitForElement(By.xpath("//div/input[@id='search']"));
            searchItem.sendKeys(item);
            searchItem.sendKeys(Keys.ENTER);
            return null;
        });
    }
    public boolean verifySearchItem(String item) {
        // Mengembalikan true jika sama, false jika tidak
        return Boolean.TRUE.equals(executeWithHandling(() -> {
            WebElement itemOnSearch = waitForElement(By.xpath("//dl/dd[1]/a"));
            String itemText = itemOnSearch.getText();
            return Objects.equals(itemText, item);
        }));
    }

    public void chooseItem(){
        executeWithHandling(() ->{
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("window.scrollBy(0, 500);");

            WebElement addSize = waitForElement(By.xpath("//div[@class='swatch-opt-1556']//div[.='S']"));
            addSize.click();

            WebElement addColor = waitForElement(By.xpath("//div[@class='swatch-opt-1556']/div[@class='swatch-attribute color']//div[2]"));
            addColor.click();
            return null;
        });
    }

    public void addToWishlist(){
        executeWithHandling(() -> {
            WebElement addWishlist = waitForElement(By.xpath(""));
            addWishlist.click();
            return null;
        });
    }
}