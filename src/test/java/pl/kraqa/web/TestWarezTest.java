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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWarezTest {
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
    public void testRedirectToTestWarez() {
        driver.get("https://sjsi.org");
        driver.findElement(By.className("hu-notice-close")).click();
        WebElement naszeInicjatywy = driver.findElement(By.className("menu-item-5400"));
        naszeInicjatywy.click();
        naszeInicjatywy.findElement(By.linkText("TESTWAREZ")).click();

        assertEquals(driver.getCurrentUrl(), "https://2024.testwarez.pl/");
        assertEquals(driver.getTitle(), "TestWarez2024 – The largest testing conference in Poland");
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

}
