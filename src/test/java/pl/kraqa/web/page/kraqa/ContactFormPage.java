package pl.kraqa.web.page.kraqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactFormPage extends BasePage<ContactFormPage> {
    private By nameInput = By.name("name");
    private By emailInput = By.name("email");
    private By subjectInput = By.name("subject");
    private By messageInput = By.name("message");
    private By submitButton = By.name("submit");
    private By confirmationMessage = By.xpath("//*[contains(text(), 'Thanks for being with us')]");

    public ContactFormPage(WebDriver webDriver) {
        super("https://kraqa.pl/kontakt/", webDriver);
    }

    public ContactFormPage fillName(String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public ContactFormPage fillEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public ContactFormPage fillSubject(String subject) {
        driver.findElement(subjectInput).sendKeys(subject);
        return this;
    }

    public ContactFormPage fillMessage(String message) {
        driver.findElement(messageInput).sendKeys(message);
        return this;
    }

    public ContactFormPage submitForm() {
        driver.findElement(submitButton).click();
        return this;
    }

    public boolean isConfirmationMessageDisplayed() {
        return driver.findElement(confirmationMessage).isDisplayed();
    }
}
