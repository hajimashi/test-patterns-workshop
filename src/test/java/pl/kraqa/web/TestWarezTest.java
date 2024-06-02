package pl.kraqa.web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWarezTest extends WebDriverTest {

    @Test
    public void testRedirectToTestWarez() {
        driver.get("https://sjsi.org");
        driver.findElement(By.className("hu-notice-close")).click();
        WebElement naszeInicjatywy = driver.findElement(By.className("menu-item-5400"));
        naszeInicjatywy.click();
        naszeInicjatywy.findElement(By.linkText("TESTWAREZ")).click();

        assertEquals(driver.getCurrentUrl(), "https://2024.testwarez.pl/");
        assertEquals(driver.getTitle(), "TestWarez2024 – The largest testing conference in Poland");
    }
}
