package util.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Sergey
 */
    public class SendAppPage  {

WebDriver driver;
    @FindBy(xpath = "//h4[@class='modal-title']/b[text()]")
    public WebElement title;

    @FindBy(name = "LastName")
    WebElement lastName;

    @FindBy(name = "FirstName")
    WebElement firstName;

    @FindBy(name = "MiddleName")
    WebElement middleName;

    @FindBy(xpath = "//*[contains(text(),'Телефон')]/..//input")
    WebElement phone;

    @FindBy(name = "Email")
    WebElement email;

    @FindBy(name = "ContactDate")
    WebElement contactDate;

    @FindBy(name = "Comment")
    WebElement comment;

    @FindBy(name = "Region")
    WebElement region;

    @FindBy(xpath = "//button[contains(text(),'Отправить')]")
    public WebElement sendButton;

    public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(title));
this.driver=driver;
    }


    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Фамилия":
                fillField(lastName, value);
                break;
            case  "Имя":
                fillField(firstName, value);
                break;
            case  "Отчество":
                fillField(middleName, value);
                break;
            case  "Телефон":
                fillField(phone, value);
                break;
            case  "Регион":
                new Select(region).selectByVisibleText("Москва");
                break;
            case  "Эл. почта":
                fillField(email, value);
                break;
            case  "Дата контакта":
                fillField(contactDate, value);
                contactDate.sendKeys(Keys.TAB);
                break;
            case  "Комментарии":
                fillField(comment, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }
    protected void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }


}
