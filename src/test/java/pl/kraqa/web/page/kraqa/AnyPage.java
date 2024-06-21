package pl.kraqa.web.page.kraqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.kraqa.web.page.kraqa.component.LazyElement;
import pl.kraqa.web.page.kraqa.component.MenuBarComponent;

public class AnyPage {
    private final WebDriver driver;
    private LazyElement<MenuBarComponent> menu;

    public AnyPage(WebDriver driver) {
        this.driver = driver;
        this.menu = new LazyElement<>(() -> new MenuBarComponent(driver.findElement(By.id("menu-1-5b6b9ad9"))));
    }

    public MenuBarComponent getMenu() {
        return menu.get();
    }
}
