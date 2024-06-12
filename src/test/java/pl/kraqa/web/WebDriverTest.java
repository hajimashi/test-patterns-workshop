package pl.kraqa.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chromium.ChromiumDriverLogLevel;
import pl.kraqa.web.page.kraqa.component.CustomChromeDriver;

import java.time.Duration;

public class WebDriverTest {
    WebDriver driver;

    @BeforeEach
    public void setupDriver() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .withLogLevel(ChromiumDriverLogLevel.INFO)
                .withAppendLog(true)
                .withLogOutput(System.out)
                .build();
        driver = new CustomChromeDriver(service);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
    }


    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}
