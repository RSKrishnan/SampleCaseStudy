package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseClass;

import java.time.Duration;

public class NewArticlePage {

    private WebDriver driver = BaseClass.driver;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private By newArticleButton = By.linkText("New Article");
    private By titleInput = By.xpath("//input[@placeholder='Article Title']");
    private By articleDesc = By.xpath("//input[@name='description']");
    private By articleContent = By.xpath("//textarea[@class='form-control']");
    private By articleTag = By.xpath("//input[@name='tags']");
    private By publishArticleButton = By.xpath("//button[text()='Publish Article']");

    public void clickNewArticleButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(newArticleButton));
        button.click();
    }

    public void enterTitle(String title) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(titleInput));
        input.sendKeys(title);
    }

    public void enterDescription(String desc) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(articleDesc));
        input.sendKeys(desc);
    }

    public void enterContent(String content) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(articleContent));
        input.sendKeys(content);
    }

    public void enterTag(String tag) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(articleTag));
        input.sendKeys(tag);
    }

    public void clickPublishArticleButton() {
        int attempts = 0;
        while (attempts < 2) {
            try {
                driver.findElement(By.xpath("//button[text()='Publish Article']")).click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
    }

    public void createArticle(String title, String desc, String content, String tag) {
        clickNewArticleButton();
        enterTitle(title);
        enterDescription(desc);
        enterContent(content);
        enterTag(tag);
        clickPublishArticleButton();
    }

    public void updateBody(String updatedBody) {
        WebElement contentArea = wait.until(ExpectedConditions.visibilityOfElementLocated(articleContent));
        contentArea.clear();
        contentArea.sendKeys(updatedBody);
        clickPublishArticleButton();
    }
}
