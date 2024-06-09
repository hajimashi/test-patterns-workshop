package pl.kraqa.web.page.kraqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactFormPage extends LoadableComponent<ContactFormPage> {
    private static final String URL = "https://kraqa.pl/kontakt/";
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
        List<WebElement> elements = driver.findElements(confirmationMessage);

        return !elements.isEmpty() && elements.get(0).isDisplayed();
    }

    @Override
    protected void load() {
        driver.get(URL);
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        assertEquals(url, URL, "Wrong Page: " + url);
    }
}
