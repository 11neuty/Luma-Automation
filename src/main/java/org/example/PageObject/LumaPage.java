package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;



import java.time.Duration;

public class LumaPage {
    public WebDriver webDriver;

    public WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public LumaPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }
    public boolean verifyStartPage(){
        WebElement verifyStart = waitForElement(By.xpath("//div/ul/li/a[contains(text(), 'Sign In')]" ));
        return verifyStart.isDisplayed();

    }
    public void clickLoginMenu() {
        WebElement loginMenu = waitForElement(By.xpath("//div/ul/li/a[contains(text(), 'Sign In')]"));
        loginMenu.click();
    }

    public void fillUsername(String uname){
        WebElement fillUname = waitForElement(By.xpath("//div/input[@id = 'email']"));
        fillUname.sendKeys(uname);
    }

    public void fillPassword(String pass){
        WebElement fillPass = waitForElement(By.xpath("//div/input[@title = 'Password']"));
        fillPass.sendKeys(pass);
    }

    public void clickLoginButton(){
        WebElement clickLogin = waitForElement(By.xpath("//div/div/button[@type = 'submit' and @class = 'action login primary']"));
        clickLogin.click();
    }

    public boolean verifyAfterLogin() {
        try {
            WebElement verifyAfterLogin = waitForElement(By.xpath("//h1/span[text()='Home Page']"));
            return verifyAfterLogin.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Element not found: " + e.getMessage());
            return false; // Mengembalikan false jika elemen tidak ditemukan
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            return false; // Mengembalikan false untuk kesalahan lain
        }
    }

    public void clickCreateAccount(){
        WebElement clickCreateAcc = waitForElement(By.xpath(""));
        clickCreateAcc.click();
    }

    public boolean verifyOnboardingPage(){
        WebElement verifOnboarding = waitForElement(By.xpath("//h1/span[text() = 'Create New Customer Account']"));
        return verifOnboarding.isDisplayed();
    }

    public void fillForm(String firstName, String lastName, String email, String pass, String confirmPass){
        WebElement firtName = waitForElement(By.xpath("//div/input[@name = 'firstname']"));
        firtName.sendKeys(firstName);

        WebElement fillLastName = waitForElement(By.xpath("//div/input[@name = 'lastname']"));
        fillLastName.sendKeys(lastName);

        WebElement fillEmail = waitForElement(By.xpath("//div/input[@name = 'email']"));
        fillEmail.sendKeys(email);

        WebElement fillPass = waitForElement(By.xpath("//div/input[@title= 'Password']"));
        fillPass.sendKeys(pass);

        WebElement fillConfirmPass = waitForElement(By.xpath("//div/input[@title= 'Confirm Password']"));
        fillConfirmPass.sendKeys(confirmPass);
    }

    public void clickCreateAnAccount(){
        WebElement clickCrateAnAccount = waitForElement(By.xpath("//div/button/span[text()='Create an Account']"));
        clickCrateAnAccount.click();
    }

    public boolean verifyCreateAccount(String expectedText){
        WebElement verifCreteaAcc = waitForElement(By.xpath(""));
        String actualText = verifCreteaAcc.getText();
        return expectedText.equals(actualText);

    }




}
