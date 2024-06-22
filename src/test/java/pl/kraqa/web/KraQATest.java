package pl.kraqa.web;

import org.junit.jupiter.api.Test;
import pl.kraqa.web.controller.PageController;
import pl.kraqa.web.fixture.Message;
import pl.kraqa.web.page.kraqa.AnyPage;
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
        new PageController(driver)
                .open_home_page()
                .send_contact_form_with_message(Message.nextWorkshopQuestion())
                .check_message_sent()
                .send_contact_form_with_message(Message.wrongEmail())
                .ensure_message_not_sent();
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
