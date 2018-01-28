package util.pagesSber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Sergey
 */
public class MainPage {
    @FindBy(xpath = "//*[contains(@class,'header_more_nav')]//*[contains(text(),'и имущество')]")
    WebElement mainMenu;
    @FindBy(xpath = "//*[contains(@class,'header_more_nav')]//*[contains(text(),'и имущество')]")
    WebElement subMenu;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectMainMenu(String menuItem) {
        mainMenu.findElement(By.xpath("//*[contains(@class,'header_more_nav')]//*[contains(text(),'"+menuItem+"')]")).click();

    }

    public void selectSubMenu(String menuItem) {
        subMenu.findElement(By.xpath("//div[contains(@class,'sbrf-div-list-inner --area bp-area header_more_nav')]//a[contains(text(),'"+menuItem+"')]")).click();

    }


}
