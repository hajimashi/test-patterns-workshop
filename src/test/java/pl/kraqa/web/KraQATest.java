package pl.kraqa.web;

import org.junit.jupiter.api.Test;
import pl.kraqa.web.page.kraqa.AnyPage;
import pl.kraqa.web.page.kraqa.ContactFormPage;
import pl.kraqa.web.page.kraqa.HomePage;
import pl.kraqa.web.page.kraqa.NewsPage;
import pl.kraqa.web.page.kraqa.component.MenuBarComponent.Tab;



import static org.junit.jupiter.api.Assertions.*;

public class KraQATest extends WebDriverTest {

    @Test
    public void testHomePage() {
        new HomePage(driver).get().getMenu().selectNewsTab();
        assertTrue(new NewsPage(driver).isFbWidgetEnabled());
    }

    @Test
    public void testContactForm() {
        //given
        new HomePage(driver).get().getMenu().selectContactTab();

        //when
        ContactFormPage contactFormPage = new ContactFormPage(driver)
                .get()                                                  //will not reload when already on the page
                .fillName("Marcin")
                .fillEmail("wrong email")
                .fillSubject("We are testing...")
                .fillMessage("This is a test message from workshops")
                .submitForm();

        //then
        assertFalse(contactFormPage.isConfirmationMessageDisplayed());

        //when
        contactFormPage.fillEmail("zolna.marcin+workshop@gmail.com").submitForm();

        //then
        assertTrue(contactFormPage.isConfirmationMessageDisplayed());
    }

    @Test
    public void testHomePageIsAccessible() {
        //given
        new HomePage(driver).get();

        for (Tab tab : Tab.values()) {
            //when
            HomePage homePage = new HomePage(driver);
            homePage.getMenu().selectTab(tab);

            new AnyPage(driver).getMenu().selectHomeTab();

            //then
            homePage.isLoaded();
        }
    }
}
