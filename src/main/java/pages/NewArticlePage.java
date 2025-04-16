package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewArticlePage {

    private WebDriver driver;
    
    By newArticleButton = By.xpath("//a[@href='#/editor']");
    By titleInput = By.xpath("//input[@placeholder='Article Title']");
    By articleDesc = By.xpath("//input[@name='description']");
    By articleContent = By.xpath("//textarea[@class='form-control']");
    By articleTag = By.xpath("//input[@name='tags']");
    By publishArticleButton = By.xpath("//button[text()='Publish Article']");


    public NewArticlePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clicknewArticleButton() {
        driver.findElement(newArticleButton).click();
    }

    public void entertitle(String title) {
        driver.findElement(titleInput).sendKeys(title);
    }

    public void enterDesc(String Desc) {
        driver.findElement(articleDesc).sendKeys(Desc);
    }

    public void enterContent(String Content) {
        driver.findElement(articleContent).click();
    }
    public void enterTag(String tag) {
        driver.findElement(articleTag).click();
    }
    public void clickpublishArticleButton() {
        driver.findElement(publishArticleButton).click();
    }


    public void createArticle(String title, String Desc,String Content,String tag) {
    	clicknewArticleButton();
    	entertitle(title);
    	enterDesc(Desc);
    	enterContent(Content);
    	enterTag(tag);
    	clickpublishArticleButton();
    	
    }    

    public void updateBody(String updatedBody) {
        driver.findElement(articleContent).clear();
        driver.findElement(articleContent).sendKeys(updatedBody);
        driver.findElement(publishArticleButton).click();
    }
}
