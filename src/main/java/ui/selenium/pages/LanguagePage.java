package ui.selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class LanguagePage {

    @FindBy(css = "a[class='footer__link js-show_lang_settings']")
    private WebElement langSettings;

    @FindBy(css = "label[for='hl_langs_en']")
    private WebElement engInterface;

    @FindBy(css = "button[type='submit']")
    private WebElement buttonSaveLang;

    @FindBy(css = "#login")
    private WebElement buttonLogin;

    private WebDriver driver;

    public LanguagePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open site and click language settings")
    public void clickLanguageSettings() {
        langSettings.click();
    }

    @Step("Click english interface")
    public void clickEngInterface() {
        engInterface.click();
    }

    @Step("Click button save language settings")
    public void clickButtonSaveLang() {
        buttonSaveLang.click();
    }

    @Step("Check text on button login on site")
    public void checkButtonLogin(String text) {
        assertEquals(buttonLogin.getText(), text);
    }
}