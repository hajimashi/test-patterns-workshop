package pl.kraqa.web.page.kraqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactFormPage {
    private final WebDriver driver;

    private By nameInput = By.name("name");
    private By emailInput = By.name("email");
    private By subjectInput = By.name("subject");
    private By messageInput = By.name("message");
    private By submitButton = By.name("submit");
    private By confirmationMessage = By.xpath("//*[contains(text(), 'Thanks for being with us')]");

    public ContactFormPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void fillTheForm(String name, String email, String subject, String message) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(subjectInput).sendKeys(subject);
        driver.findElement(messageInput).sendKeys(message);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    public boolean isConfirmationMessageDisplayed() {
        return driver.findElement(confirmationMessage).isDisplayed();
    }
}
