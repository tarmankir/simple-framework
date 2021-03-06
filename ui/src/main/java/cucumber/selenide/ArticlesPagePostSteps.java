package cucumber.selenide;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import selenide.pages.MainPage;
import selenide.pages.PostPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertEquals;
import static settings.UiConfig.getUiSetting;

public class ArticlesPagePostSteps {

    private MainPage mainPage;
    private PostPage postPage;

    private String votesCountOnMainPage;

    @Given("I am open articles page")
    public void IAmOpenArticlesPage() {
        open(getUiSetting("mainURL"));
        mainPage = page(MainPage.class);
        postPage = page(PostPage.class);

        votesCountOnMainPage = mainPage.getArticleVotesCount(8);
    }

    @When("^I am open article ([^\"]*)$")
    public void IAmOpenArticle(int articleIndex) {
        mainPage.openArticle(articleIndex);
    }

    @And("I am check post title")
    public void IAmCheckPostTitle() {
        postPage.checkPostTitle();
    }

    @Then("I am assert votes count")
    public void IAmAssertVotesCount() {
        assertEquals(votesCountOnMainPage, postPage.getPostVotesCount());
    }
}