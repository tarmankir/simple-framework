package selenide.browser;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class ChromeSelenideSearchPage {

    @AndroidFindBy(xpath = "//input[@name='q']")
    private SelenideElement searchField;

    @AndroidFindBy(xpath = "//button[@class='tm-rss-button tm-rss-button_default']")
    private SelenideElement copyLinkButton;

    @AndroidFindBy(xpath = "//div[contains(text(),'Ссылка скопирована в буфер обмена')]")
    private SelenideElement copyLinkPopUp;

    @Step("Enter text in search field")
    public void enterTextInSearchField(String text) {
        searchField.setValue(text);
        searchField.pressEnter();
    }

    @Step("Click on copy link button")
    public void clickOnCopyLinkButton() {
        copyLinkButton.click();
    }

    @Step("Check copy link pop up")
    public void checkCopyLinkPopUp() {
        copyLinkPopUp.isEnabled();
    }
}