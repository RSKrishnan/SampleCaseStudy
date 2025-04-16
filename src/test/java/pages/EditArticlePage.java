package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseClass;

import java.time.Duration;

public class EditArticlePage {
    private WebDriver driver = BaseClass.driver;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private By editBtn = By.xpath("//a[contains(text(),'Edit Article')]");
    private By deleteBtn = By.cssSelector(".btn.btn-primary");
    private By updateArticleBtn = By.xpath("//button[text()='Update Article']");

    public void editArticle() {
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(editBtn));
        editButton.click();
    }

    public void deleteArticle() {
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
        deleteButton.click();
    }

    public void clickUpdateArticleButton() {
        WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(updateArticleBtn));
        updateButton.click();
    }
}
