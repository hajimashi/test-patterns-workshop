package pl.kraqa.web.page.kraqa;

import org.openqa.selenium.WebDriver;
import pl.kraqa.web.page.kraqa.component.LazyElement;
import pl.kraqa.web.page.kraqa.component.MenuBarComponent;

public class AnyPage {
    private final WebDriver driver;
    private LazyElement<MenuBarComponent> menu;

    public AnyPage(WebDriver driver) {
        this.driver = driver;
        this.menu = MenuBarComponent.lazyLoad(driver);
    }

    public MenuBarComponent getMenu() {
        return menu.get();
    }
}
