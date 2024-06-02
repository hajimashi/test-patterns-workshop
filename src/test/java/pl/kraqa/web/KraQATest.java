package pl.kraqa.web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static org.junit.jupiter.api.Assertions.*;

public class KraQATest extends WebDriverTest {

    @Test
    public void testHomePage() {
        driver.get("https://kraqa.pl");
        WebElement aktualnosci = driver.findElement(By.className("menu-item-4770"));
        aktualnosci.click();
        WebElement fbWidget = driver.findElement(By.xpath("//iframe[@title='fb:page Facebook Social Plugin']"));
        assertTrue(fbWidget.isEnabled());
    }

    @Test
    public void testContactForm() {
        driver.get("https://kraqa.pl");
        WebElement contact = driver.findElement(By.className("menu-item-4365"));
        contact.click();
        driver.findElement(By.name("name")).sendKeys("Marcin");
        driver.findElement(By.name("email")).sendKeys("zolna.marcin+workshop@gmail.com");
        driver.findElement(By.name("subject")).sendKeys("We are testing...");
        driver.findElement(By.name("message")).sendKeys("This is a test message from workshops");
        driver.findElement(By.name("submit")).click();

        assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Thanks for being with us')]")).isDisplayed());
    }

}
