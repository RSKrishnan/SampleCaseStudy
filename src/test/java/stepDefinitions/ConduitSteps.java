package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.util.List;
import java.util.Map;

public class ConduitSteps {

    WebDriver driver = utils.TestHooks.driver;
    LoginPage loginPage = new LoginPage(driver);
    NewArticlePage newArticlePage = new NewArticlePage(driver);
    ArticlePage articlePage = new ArticlePage(driver);
    EditArticlePage editPage = new EditArticlePage(driver);

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
        newArticlePage.clicknewArticleButton();
    }

    @When("User enters Article details")
    public void user_enters_article_details(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> article = data.get(0);
        newArticlePage.createArticle(article.get("title"), article.get("Desc"), article.get("Content"), article.get("tag"));
        newArticlePage.clickpublishArticleButton();
    }

    @Then("Article must be created")
    public void article_must_be_created() {
        Assert.assertTrue(articlePage.isArticleDisplayed("Sample Title"));
    }

    @Given("User should be on Global Feed page")
    public void user_should_be_on_global_feed_page() {
        articlePage.clickGlobalFeed();
    }

    @When("User select an article {string}")
    public void user_select_an_article(String title) {
    	articlePage.selectArticle(title);
    }

    @Then("Article detail page must be displayed")
    public void article_detail_page_must_be_displayed() {
        Assert.assertTrue(articlePage.isArticleDisplayed("Sample Title"));
    }

    @When("User update article detail")
    public void user_update_article_detail() {
        editPage.editArticle();
        newArticlePage.updateBody("Updated Content");
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
