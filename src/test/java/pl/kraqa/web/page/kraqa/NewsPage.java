package pl.kraqa.web.page.kraqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewsPage {

    private final WebDriver driver;

    private By fbWidget = By.xpath("//iframe[@title='fb:page Facebook Social Plugin']");

    public NewsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFbWidgetEnabled() {
        return driver.findElement(fbWidget).isEnabled();
    }
}
