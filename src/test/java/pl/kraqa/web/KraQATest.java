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
        //given
        driver.get("https://kraqa.pl/kontakt");
        //new HomePage(driver).selectContactTab();

        //when
        ContactFormPage contactFormPage = new ContactFormPage(driver)
                .fillName("Marcin")
                .fillEmail("wrong email")
                .fillSubject("We are testing...")
                .fillMessage("This is a test message from workshops")
                .submitForm();

        //then
        assertFalse(contactFormPage.isConfirmationMessageDisplayed());

        //when
        contactFormPage.fillEmail("zolna.marcin+workshop@gmail.com")
                .submitForm();

        //then
        assertTrue(contactFormPage.isConfirmationMessageDisplayed());
    }

}
