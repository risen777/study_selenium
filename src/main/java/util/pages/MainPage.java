package util.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Sergey
 */
public class MainPage {
    @FindBy(xpath = "//ol[contains(@class,'rgs-menu pull-left')]")
    WebElement mainMenu;

    @FindBy(xpath = "//div[contains(@class,'grid rgs-main-menu-links')]")
    WebElement subMenu;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectMainMenu(String menuItem) {
mainMenu.findElement(By.xpath(".//li[contains(@class,'current')]/*[contains(text(),'"+menuItem+"')]")).click();

    }

    public void selectSubMenu(String menuItem) {
        subMenu.findElement(By.xpath(".//li//a[contains(text(),'"+menuItem+"')]")).click();

    }


}
