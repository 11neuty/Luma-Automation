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
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement loginMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/ul/li/a[contains(text(), 'Sign In')]")));
        loginMenu.click();
    }

    public void fillUsername(String uname){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement fillUname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@id = 'email']")));
        fillUname.sendKeys(uname);
    }

    public void fillPassword(String pass){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement fillPass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@title = 'Password']")));
        fillPass.sendKeys(pass);
    }

    public void clickLoginButton(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement clickLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/button[@type = 'submit' and @class = 'action login primary']")));
        clickLogin.click();
    }

    public boolean verifyAfterLogin() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        try {
            WebElement verifyAfterLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1/span[text()='My Account']")));
            return verifyAfterLogin.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Element not found: " + e.getMessage());
            return false; // Mengembalikan false jika elemen tidak ditemukan
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            return false; // Mengembalikan false untuk kesalahan lain
        }
    }


}
