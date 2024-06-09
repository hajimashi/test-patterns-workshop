package pl.kraqa.web.page.kraqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends LoadableComponent<HomePage> {
    private static final String URL = "https://kraqa.pl/";
    private final WebDriver driver;

    private By menuContactTab = By.className("menu-item-4365");
    private By menuNewsTab = By.className("menu-item-4770");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectContactTab() {
        driver.findElement(menuContactTab).click();
    }

    public void selectNewsTab() {
        driver.findElement(menuNewsTab).click();
    }

    @Override
    protected void load() {
        driver.get(URL);
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        assertEquals(url, URL, "Wrong Page: " + url);
    }
}
