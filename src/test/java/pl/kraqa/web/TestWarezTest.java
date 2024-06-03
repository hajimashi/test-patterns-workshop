package pl.kraqa.web;

import org.junit.jupiter.api.Test;
import pl.kraqa.web.page.testwarez.SjsiHomePage;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWarezTest extends WebDriverTest {

    @Test
    public void testRedirectToTestWarez() {
        driver.get("https://sjsi.org");
        SjsiHomePage sjsiHomePage = new SjsiHomePage(driver);
        sjsiHomePage.closeCookieNotice();
        sjsiHomePage.selectInitiativesTab();
        sjsiHomePage.clickTestWarezLink();

        assertEquals(driver.getCurrentUrl(), "https://2024.testwarez.pl/");
        assertEquals(driver.getTitle(), "TestWarez2024 – The largest testing conference in Poland");
    }
}
