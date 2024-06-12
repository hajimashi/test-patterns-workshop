package pl.kraqa.web.page.kraqa.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MenuBarComponent {
    private final WebElement root;

    private By homeTab = By.className("menu-item-4363");
    private By kraqaTab = By.className("menu-item-4367");
    private By qarantannaTab = By.className("menu-item-4364");
    private By skladqaTab = By.className("menu-item-4817");
    private By dupqaTab = By.className("menu-item-5107");
    private By newsTab = By.className("menu-item-4770");
    private By aboutUsTab = By.className("menu-item-4368");
    private By contactTab = By.className("menu-item-4365");

    public MenuBarComponent(WebElement root) {
        this.root = root;
    }

    public void selectHomeTab() {
        root.findElement(homeTab).click();
    }
    public void selectKraQATab() {
        root.findElement(kraqaTab).click();
    }
    public void selectQArantannaTab() {
        root.findElement(qarantannaTab).click();
    }
    public void selectSkladQATab() {
        root.findElement(skladqaTab).click();
    }
    public void selectNewsTab() {
        root.findElement(newsTab).click();
    }
    public void selectAboutUsTab() {
        root.findElement(aboutUsTab).click();
    }
    public void selectContactTab() {
        root.findElement(contactTab).click();
    }
    public void selectDupQATab() {
        root.findElement(dupqaTab).click();
    }

    public void selectTab(Tab tab) {
        switch (tab) {
            case KRAQA -> selectKraQATab();
            case QARANTANNA -> selectQArantannaTab();
            case SKLADQA -> selectSkladQATab();
            case ABOUTUS -> selectAboutUsTab();
            case NEWS -> selectNewsTab();
            case CONTACT -> selectContactTab();
            case DUPQA -> selectDupQATab();
            case HOME -> selectHomeTab();
        }
    }

    public enum Tab {
        HOME, KRAQA, SKLADQA, QARANTANNA, DUPQA, ABOUTUS, NEWS, CONTACT
    }
}
