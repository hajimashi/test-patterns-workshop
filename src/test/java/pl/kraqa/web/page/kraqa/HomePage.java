package pl.kraqa.web.page.kraqa;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage<HomePage> {
    public HomePage(WebDriver driver) {
        super("https://kraqa.pl/", driver);
    }
}
