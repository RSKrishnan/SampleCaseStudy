package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class LoginPage {
    WebDriver driver = BaseClass.driver;

    By signInLink = By.xpath("//a[@href='#/login']");
    By emailInput = By.xpath("//input[@placeholder='Email']");
    By passwordInput = By.xpath("//input[@placeholder='Password']");
    By signInButton = By.xpath("//button[text()='Login']");

    // No need to pass WebDriver from constructor; already shared via BaseClass
    public LoginPage() {
        // Optional: Validate driver is not null
        if (driver == null) {
            throw new IllegalStateException("WebDriver not initialized in BaseClass.");
        }
    }

    public void clickSignInLink() {
        driver.findElement(signInLink).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void login(String email, String password) {
        clickSignInLink();
        enterEmail(email);
        enterPassword(password);
        clickSignInButton();
    }

    public void navigateToLoginPage() {
        driver.get("https://conduit-realworld-example-app.fly.dev/");
    }
}
