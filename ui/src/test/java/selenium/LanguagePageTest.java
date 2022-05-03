package selenium;

import org.testng.annotations.Test;
import selenium.pages.LanguagePage;
import settings.SeleniumSelenoidSetup;

import static org.openqa.selenium.support.PageFactory.initElements;
import static settings.UiConfig.getUiSetting;

public class LanguagePageTest extends SeleniumSelenoidSetup {

    @Test
    public void languagePageTest() {
        driver.get(getUiSetting("mainURL"));
        LanguagePage languagePage = initElements(driver, LanguagePage.class);
        languagePage.clickLanguageSettings();
        languagePage.clickEngInterface();
        languagePage.clickButtonSaveLang();
        languagePage.checkButtonLogin("Log in");
    }
}