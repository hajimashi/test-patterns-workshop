package pl.kraqa.web.page.kraqa.component;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class CustomChromeDriver extends ChromeDriver {
    public CustomChromeDriver(ChromeDriverService service) {
        super(service);
    }

    @Override
    public WebElement findElement(By by) {
        try {
            return super.findElement(by);
        } catch (NoSuchElementException e) {
            return new NullElement();
        }
    }
}
