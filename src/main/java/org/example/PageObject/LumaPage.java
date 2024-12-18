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

import java.time.Duration;
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

    public boolean verifyStartPage() {
        WebElement verifyStart = waitForElement(By.xpath("//div/ul/li/a[contains(text(), 'Sign In')]"));
        return verifyStart.isDisplayed();
    }

    public void clickLoginMenu() {
        WebElement loginMenu = waitForElement(By.xpath("//div/ul/li/a[contains(text(), 'Sign In')]"));
        loginMenu.click();
    }

    public void fillUsername(String uname) {
        WebElement fillUname = waitForElement(By.xpath("//div/input[@id='email']"));
        fillUname.sendKeys(uname);
    }

    public void fillPassword(String pass) {
        WebElement fillPass = waitForElement(By.xpath("//div/input[@title='Password']"));
        fillPass.sendKeys(pass);
    }

    public void clickLoginButton() {
        WebElement clickLogin = waitForElement(By.xpath("//div/div/button[@type='submit' and @class='action login primary']"));
        clickLogin.click();
    }

    public boolean verifyAfterLogin() {
        try {
            WebElement verifyAfterLogin = waitForElement(By.xpath("//h1/span[text()='Home Page']"));
            return verifyAfterLogin.isDisplayed();
        } catch (TimeoutException e) {
            logger.warning("Element not found: " + e.getMessage());
            return false;
        } catch (Exception e) {
            logger.severe("An unexpected error occurred: " + e.getMessage());
            return false;
        }
    }

    public void clickCreateAccount() {
        WebElement clickCreateAcc = waitForElement(By.xpath("//div[@class='panel header']//a[.='Create an Account']"));
        clickCreateAcc.click();
    }

    public boolean verifyOnboardingPage() {
        WebElement verifOnboarding = waitForElement(By.xpath("//h1/span[text()='Create New Customer Account']"));
        return verifOnboarding.isDisplayed();
    }

    public void fillForm(String firstName, String lastName, String email, String pass, String confirmPass) {
        WebElement firstNameField = waitForElement(By.xpath("//div/input[@name='firstname']"));
        firstNameField.sendKeys(firstName);

        WebElement fillLastName = waitForElement(By.xpath("//div/input[@name='lastname']"));
        fillLastName .sendKeys(lastName);

        WebElement fillEmail = waitForElement(By.xpath("//div/input[@name='email']"));
        fillEmail.sendKeys(email);

        WebElement fillPass = waitForElement(By.xpath("//div/input[@title='Password']"));
        fillPass.sendKeys(pass);

        WebElement fillConfirmPass = waitForElement(By.xpath("//div/input[@title='Confirm Password']"));
        fillConfirmPass.sendKeys(confirmPass);
    }

    public void clickCreateAnAccount() {
        WebElement clickCreateAnAccount = waitForElement(By.xpath("//div/button/span[text()='Create an Account']"));
        clickCreateAnAccount.click();
    }

    public boolean verifyCreateAccount(String expectedText) {
        logger.info("Memulai verifikasi akun dengan teks yang diharapkan: " + expectedText);

        try {
            logger.info("Menunggu elemen untuk muncul...");
            WebElement verifCreateAcc = waitForElement(By.xpath("//div[.='Thank you for registering with Main Website Store.']"));
            logger.info("Elemen ditemukan: " + verifCreateAcc.getText());

            String actualText = verifCreateAcc.getText();
            logger.info("Teks yang sebenarnya: " + actualText);

            if (!expectedText.equals(actualText)) {
                logger.warning("Teks tidak cocok. Mengembalikan false.");
                return false;
            }

            logger.info("Teks cocok. Melanjutkan untuk memeriksa elemen 'My Account'...");
            WebElement myAcc = waitForElement(By.xpath("//h1/span[text()='My Account']"));
            boolean isDisplayed = myAcc.isDisplayed();
            logger.info("'My Account' ditampilkan: " + isDisplayed);
            return isDisplayed;
        } catch (NoSuchElementException e) {
            logger.warning("Element not found: " + e.getMessage());
            return false;
        } catch (StaleElementReferenceException e) {
            logger.warning("Stale element reference: " + e.getMessage());
            return false;
        } catch (Exception e) {
            logger.severe("An error occurred: " + e.getMessage());
            return false;
        }
    }

    public boolean verifyErrorLogin() {
        try {
            WebElement errorLogin = waitForElement(By.xpath("//div[@class='message-error error message']/div[contains(.,'The account')]"));
            return errorLogin.isDisplayed();
        } catch (NoSuchElementException e) {
            logger.warning("Error login element not found: " + e.getMessage());
            return false;
        } catch (StaleElementReferenceException e) {
            logger.warning("Stale element reference: " + e.getMessage());
            return false;
        } catch (Exception e) {
            logger.severe("An error occurred while verifying error login: " + e.getMessage());
            return false;
        }
    }


    public boolean verifyEmailError() {
        try {
            // Mencoba untuk menunggu dan menemukan elemen error email
            WebElement emailError = waitForElement(By.xpath("//div/div[contains(text(), 'Please enter a valid email address')]"));

            // Mengembalikan true jika elemen ditampilkan
            return emailError.isDisplayed();
        } catch (NoSuchElementException e) {
            // Menangani jika elemen tidak ditemukan
            System.out.println("Email error message element not found: " + e.getMessage());
            return false; // Mengembalikan false jika elemen tidak ditemukan
        } catch (StaleElementReferenceException e) {
            // Menangani jika elemen tidak lagi valid
            System.out.println("Stale element reference: " + e.getMessage());
            return false; // Mengembalikan false jika elemen tidak lagi valid
        } catch (Exception e) {
            // Menangani pengecualian lainnya
            System.out.println("An error occurred while verifying email error message: " + e.getMessage());
            return false; // Mengembalikan false untuk pengecualian lainnya
        }
    }
}