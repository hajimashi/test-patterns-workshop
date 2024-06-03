package pl.kraqa.web;

import org.junit.jupiter.api.Test;
import pl.kraqa.web.page.kraqa.ContactFormPage;
import pl.kraqa.web.page.kraqa.HomePage;
import pl.kraqa.web.page.kraqa.NewsPage;


import static org.junit.jupiter.api.Assertions.*;

public class KraQATest extends WebDriverTest {

    @Test
    public void testHomePage() {
        driver.get("https://kraqa.pl");
        new HomePage(driver).selectNewsTab();
        assertTrue(new NewsPage(driver).isFbWidgetEnabled());
    }

    @Test
    public void testContactForm() {
        driver.get("https://kraqa.pl");
        new HomePage(driver).selectContactTab();

        ContactFormPage contactFormPage = new ContactFormPage(driver);
        contactFormPage.fillTheForm("Marcin", "zolna.marcin+workshop@gmail.com", "We are testing...", "This is a test message from workshops");
        contactFormPage.submitForm();

        assertTrue(contactFormPage.isConfirmationMessageDisplayed());
    }

}
