package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseClass;

import java.time.Duration;

public class ArticlePage {

    private WebDriver driver = BaseClass.driver;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private By homeLink = By.linkText("Home");
    private By globalFeedTab = By.className("nav-link");
    private By articleTitle = By.cssSelector("h1");

    public boolean isAtHomePage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homeLink)).isDisplayed();
    }
    public void clickHomeLink() {
        wait.until(ExpectedConditions.elementToBeClickable(homeLink)).click();
    }
    public void clickGlobalFeed() {
        wait.until(ExpectedConditions.elementToBeClickable(globalFeedTab)).click();
    }

    public void selectArticle(String title) {
        By specificArticleTitle = By.xpath("//h1[text()='" + title + "']");
        wait.until(ExpectedConditions.elementToBeClickable(specificArticleTitle)).click();
    }

    public boolean isArticleDisplayed(String title) {
        By specificArticleTitle = By.xpath("//h1[text()='" + title + "']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(specificArticleTitle)).isDisplayed();
    }

    public String getArticleTitle() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(articleTitle));
        return titleElement.getText();
    }
    public void goToArticleFromHome(String title) {
        wait.until(ExpectedConditions.elementToBeClickable(homeLink)).click();
        clickGlobalFeed();
        selectArticle(title);
    }
    public boolean isGlobalFeedDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(globalFeedTab)).isDisplayed();
    }
}
