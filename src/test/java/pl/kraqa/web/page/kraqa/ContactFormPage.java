package pl.kraqa.web.page.kraqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactFormPage extends BasePage<ContactFormPage> {
    @FindBy(name = "name")
    private WebElement nameInput;
    @FindBy(name = "email")
    private WebElement emailInput;
    @FindBy(name = "subject")
    private WebElement subjectInput;
    @FindBy(name = "message")
    private WebElement messageInput;
    @FindBy(name = "submit")
    private WebElement submitButton;
    @FindBy(xpath = "//*[contains(text(), 'Thanks for being with us')]")
    private WebElement confirmationMessage;

    public ContactFormPage(WebDriver webDriver) {
        super("https://kraqa.pl/kontakt/", webDriver);
    }

    public ContactFormPage fillName(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    public ContactFormPage fillEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public ContactFormPage fillSubject(String subject) {
        subjectInput.sendKeys(subject);
        return this;
    }

    public ContactFormPage fillMessage(String message) {
        messageInput.sendKeys(message);
        return this;
    }

    public ContactFormPage submitForm() {
        submitButton.click();
        return this;
    }

    public boolean isConfirmationMessageDisplayed() {
        return confirmationMessage.isDisplayed();
    }
}
