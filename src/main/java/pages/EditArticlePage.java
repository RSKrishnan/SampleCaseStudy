package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditArticlePage {
	 WebDriver driver;
	 
	 By editBtn = By.xpath("//a[contains(text(),'Edit Article')]");
	 By deleteBtn = By.cssSelector(".btn.btn-primary");

	    public EditArticlePage(WebDriver driver) {
	        this.driver = driver;
	    }
	    public void editArticle() {
	        driver.findElement(editBtn).click();
	    }

		public void deleteArticle() {
	        driver.findElement(deleteBtn).click();
			
		}
	}