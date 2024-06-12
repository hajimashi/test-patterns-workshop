package pl.kraqa.web.page.kraqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import pl.kraqa.web.page.kraqa.component.MenuBarComponent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    protected final String URL;
    protected final WebDriver driver;
    protected MenuBarComponent menu;

    protected BasePage(String url, WebDriver driver) {
        URL = url;
        this.driver = driver;
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

    public MenuBarComponent getMenu() {
        if (menu == null) {
            this.menu = new MenuBarComponent(driver.findElement(By.id("menu-1-5b6b9ad9")));
        }

        return menu;
    }

    public String getUrl() {
        return URL;
    }
}
