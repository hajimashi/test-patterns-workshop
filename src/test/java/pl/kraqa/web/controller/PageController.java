package pl.kraqa.web.controller;

import org.openqa.selenium.WebDriver;
import pl.kraqa.web.fixture.Message;
import pl.kraqa.web.page.kraqa.ContactFormPage;
import pl.kraqa.web.page.kraqa.HomePage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageController {
    WebDriver driver;

    public PageController(WebDriver driver) {
        this.driver = driver;
    }

    public PageController open_home_page() {
        new HomePage(driver).get().getMenu().selectContactTab();
        return this;
    }

    public PageController send_contact_form_with_message(Message message) {
        new ContactFormPage(driver)
                .get()
                .fillName(message.getName())
                .fillEmail(message.getEmail())
                .fillSubject(message.getSubject())
                .fillMessage(message.getMessage())
                .submitForm();

        return this;
    }


    public PageController check_message_sent() {
        assertTrue(new ContactFormPage(driver).get().isConfirmationMessageDisplayed());

        return this;
    }

    public PageController ensure_message_not_sent() {
        assertFalse(new ContactFormPage(driver).get().isConfirmationMessageDisplayed());

        return this;
    }
}
