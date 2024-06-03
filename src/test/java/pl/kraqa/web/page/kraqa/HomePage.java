package pl.kraqa.web.page.kraqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
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
}
