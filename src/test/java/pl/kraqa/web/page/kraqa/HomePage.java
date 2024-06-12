package pl.kraqa.web.page.kraqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import pl.kraqa.web.page.kraqa.component.MenuBarComponent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends LoadableComponent<HomePage> {
    private static final String URL = "https://kraqa.pl/";
    private final WebDriver driver;
    private MenuBarComponent menu;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public MenuBarComponent getMenu() {
        if (menu == null) {
            this.menu = new MenuBarComponent(driver.findElement(By.id("menu-1-5b6b9ad9")));
        }

        return menu;
    }

    @Override
    protected void load() {
        driver.get(URL);
    }

    @Override
    public void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        assertEquals(url, URL, "Wrong Page: " + url);
    }
}
