package pl.kraqa.web.page.kraqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewsPage extends LoadableComponent<NewsPage> {
    private static final String URL = "https://kraqa.pl/aktualnosci/";

    private final WebDriver driver;

    private By fbWidget = By.xpath("//iframe[@title='fb:page Facebook Social Plugin']");

    public NewsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFbWidgetEnabled() {
        return driver.findElement(fbWidget).isEnabled();
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
