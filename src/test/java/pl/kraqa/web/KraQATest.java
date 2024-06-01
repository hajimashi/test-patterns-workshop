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
    public void testKraQAHomePage() {
        driver.get("https://kraqa.pl");
        WebElement aktualnosci = driver.findElement(By.className("menu-item-4770"));
        aktualnosci.click();
        WebElement fbWidget = driver.findElement(By.xpath("//iframe[@title='fb:page Facebook Social Plugin']"));
        assertTrue(fbWidget.isEnabled());
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

}
