package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;
import utilities.BaseClass;

import java.util.List;
import java.util.Map;

public class ConduitSteps {

    WebDriver driver = BaseClass.driver;

    LoginPage loginPage = new LoginPage();
    NewArticlePage newArticlePage = new NewArticlePage();
    ArticlePage articlePage = new ArticlePage();
    EditArticlePage editPage = new EditArticlePage();

    @Given("User is on Login page")
    public void user_is_on_login_page() {
        loginPage.navigateToLoginPage();
    }

    @When("User provide {string} and {string}")
    public void user_provide_credentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("User should be on Home Page")
    public void user_should_be_on_home_page() {
        Assert.assertTrue(articlePage.isAtHomePage());
    }

    @Given("User should be on New Article Page")
    public void user_should_be_on_new_article_page() {
        newArticlePage.clickNewArticleButton();
    }

    @When("User enters Article details")
    public void user_enters_article_details(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> article = data.get(0);
        newArticlePage.createArticle(
                article.get("title"),
                article.get("Desc"),
                article.get("Content"),
                article.get("tag")
        );
        newArticlePage.clickPublishArticleButton();
    }

    @Then("Article must be created")
    public void article_must_be_created() {
        Assert.assertTrue(articlePage.isArticleDisplayed("Sample Title"));
    }

    /** @Given("User is on the Global Feed page")
    public void user_is_on_the_global_feed_page() {
    	articlePage.clickHomeLink();
        articlePage.clickGlobalFeed();
        Assert.assertTrue("Global Feed is not displayed", articlePage.isGlobalFeedDisplayed());
    }

    @When("User selects the article titled {string}")
    public void user_selects_the_article_titled(String title) {
        articlePage.selectArticle(title);      // Select the article by title
    }

    @Then("The article detail page should be displayed for {string}")
    public void the_article_detail_page_should_be_displayed_for(String title) {
        Assert.assertTrue("Article detail page is not displayed for: " + title, articlePage.isArticleDisplayed(title)); } **/
   

    @When("User updates the article titled {string} with new content {string}")
    public void user_updates_the_article_titled_with_new_content(String title, String updatedContent) {
        //articlePage.goToArticleFromHome(title);
        editPage.editArticle();
        newArticlePage.updateBody(updatedContent);
        editPage.clickUpdateArticleButton();
    }

    @Then("Article detail must be updated")
    public void article_detail_must_be_updated() {
        Assert.assertTrue(driver.getPageSource().contains("Updated Content"));
    }

    @When("User delete article")
    public void user_delete_article() {
        editPage.deleteArticle();
    }

    @Then("Article must be deleted")
    public void article_must_be_deleted() {
        Assert.assertFalse(driver.getPageSource().contains("Sample Title"));
    } 
}
