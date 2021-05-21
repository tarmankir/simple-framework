package ui.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class FeedbackPage {

    @FindBy(css = "option[value*='8']")
    private SelenideElement listOption;

    @FindBy(css = "input[name*='email']")
    private SelenideElement emailField;

    @FindBy(css = "#message_textarea")
    private SelenideElement massageField;

    @FindBy(css = "#message_textarea")
    private SelenideElement massageFieldForCucumber;

    @FindBy(css = "input[name*='feedback_confidantial']")
    private SelenideElement checkboxInput;

    @FindBy(css = "button[name*='submit']")
    private SelenideElement submitButton;

    public void listOptionTake() {
        listOption.click();
    }

    public void emailFieldTake() {
        emailField.setValue("bigkir@yandex.ru");
    }

    public void massageFieldTake() {
        massageField.setValue("Текстовые тестовые данные");
    }

    public void massageFieldTakeForCucumber(String text) {
        massageFieldForCucumber.setValue(text);
    }

    public void checkSubmitButton(String text) {
        submitButton.shouldHave(text(text));
    }
}