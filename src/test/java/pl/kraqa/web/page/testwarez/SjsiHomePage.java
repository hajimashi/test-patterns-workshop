package pl.kraqa.web.page.testwarez;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SjsiHomePage {
    private final WebDriver driver;
    private By cookieNoticeClose = By.className("hu-notice-close");
    private By menuInitiativesTab = By.className("menu-item-5400");
    private By menuTestWarezLink = By.linkText("TESTWAREZ");

    public SjsiHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void closeCookieNotice() {
        driver.findElement(cookieNoticeClose).click();
    }

    public void selectInitiativesTab() {
        driver.findElement(menuInitiativesTab).click();
    }

    public void clickTestWarezLink() {
        driver.findElement(menuTestWarezLink).click();
    }
}
