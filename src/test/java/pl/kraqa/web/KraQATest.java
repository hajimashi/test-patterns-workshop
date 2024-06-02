package pl.kraqa.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chromium.ChromiumDriverLogLevel;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class KraQATest {

    WebDriver driver;

    @BeforeEach
    public void setupDriver() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .withLogLevel(ChromiumDriverLogLevel.INFO)
                .withAppendLog(true)
                .withLogOutput(System.out)
                .build();
        driver = new ChromeDriver(service);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }

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

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

}
