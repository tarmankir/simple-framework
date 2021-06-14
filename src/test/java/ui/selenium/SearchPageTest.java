package ui.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.selenium.pages.SearchPage;
import ui.settings.FirefoxSetup;
import ui.settings.SeleniumListener;

import static org.openqa.selenium.support.PageFactory.initElements;
import static ui.settings.Config.getSetting;

@Listeners(SeleniumListener.class)
public class SearchPageTest extends FirefoxSetup {

    private WebDriver driver;
    private SearchPage searchPage;

    @BeforeMethod
    public void driverSet() {
        driver = new FirefoxDriver(getOptions());
        searchPage = initElements(driver, SearchPage.class);
        driver.get(getSetting("mainURL"));
    }

    @AfterMethod
    void afterMethod() {
        driver.close();
    }

    @Test
    public void searchPageTest() {
        searchPage.clickOnSearchButton();
        searchPage.enterTestSearch("Тестирование");
        searchPage.checkSearch("Тестирование");
    }
}