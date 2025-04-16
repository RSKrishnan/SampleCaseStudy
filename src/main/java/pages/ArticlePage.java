package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticlePage {

    private WebDriver driver;
    
    By homeLink = By.xpath("//a[@href='#/']");
    By globalFeedTab = By.xpath("//button[text()='Global Feed']");
    By articleTitle = By.cssSelector("h1");

    public ArticlePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAtHomePage() {
        return driver.findElement(homeLink).isDisplayed();
    }

    public void clickGlobalFeed() {
        driver.findElement(globalFeedTab).click();
    }

    public void selectArticle(String title) {
        driver.findElement(By.xpath("//h1[text()='" + title + "']")).click();
    }

    public boolean isArticleDisplayed(String title) {
        return driver.findElement(By.xpath("//h1[text()='" + title + "']")).isDisplayed();
    }
}
