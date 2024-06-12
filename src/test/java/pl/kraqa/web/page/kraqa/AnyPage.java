package pl.kraqa.web.page.kraqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.kraqa.web.page.kraqa.component.MenuBarComponent;

public class AnyPage {
    private final WebDriver driver;
    private MenuBarComponent menu;

    public AnyPage(WebDriver driver) {
        this.driver = driver;
    }

    public MenuBarComponent getMenu() {
        if (menu == null) {
            this.menu = new MenuBarComponent(driver.findElement(By.id("menu-1-5b6b9ad9")));
        }

        return menu;
    }
}
