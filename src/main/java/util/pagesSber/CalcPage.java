package util.pagesSber;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Sergey
 */
public class CalcPage {
    public void testSberbank(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);

        while (!driver.getTitle().equals("Сбербанк страхование")) {
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);



            }}}
    @FindBy(xpath = "//div[text() = 'Минимальная']/..")
    WebElement minSum;

    @FindBy(xpath = "//span[text() = 'Оформить']")
    WebElement sendNext;

    @FindBy(xpath = "//span[contains(text(),'Оформление')]")
    public WebElement title;

    @FindBy(name = "insured0_surname")
    WebElement insLastName;

    @FindBy(name = "insured0_name")
    WebElement insFirstName;

    @FindBy(name = "surname")
    WebElement lastName;

    @FindBy(name = "name")
    WebElement firstName;
    @FindBy(name = "middlename")
    WebElement middleName;
    @FindBy(name = "birthDate")
    WebElement birthDate;

    @FindBy(xpath = "//*[contains(text(),'Пол')]/..//*[contains(@class,'b-radio-field b-checked-radio-field')]")
    WebElement sex;

    @FindBy(name = "passport_series")
    WebElement passportSeries;

    @FindBy(name = "passport_number")
    WebElement passporNumber;

    @FindBy(name = "issueDate")
    WebElement issueDate;

    @FindBy(name = "issuePlace")
    WebElement issuePlace;

    @FindBy(xpath = "//*[contains(text(),'Продолжить')]")
    public WebElement sendButtonNext;
    public void clickMinSum() {
        minSum.click();
    }

    public void clickSendNext() {
        sendNext.click();
    }
    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Фамилия застрахованного":
                fillField(insLastName, value);
                break;
            case  "Имя застрахованного":
                fillField(insFirstName, value);
                break;

            case  "Фамилия":
                fillField(lastName, value);
                break;
            case  "Имя":
                fillField(firstName, value);
                break;
            case  "Отчество":
                fillField(middleName, value);
                break;
            case  "Дата рождения":
                fillField(birthDate, value);
                break;
            case  "Пол":
                fillField(sex, value);
                break;
            case  "Серия паспорта":
                fillField(passportSeries, value);
                break;
            case  "Номер паспорта":
                fillField(passporNumber, value);
                break;
            case  "Дата выдачи":
                fillField(issueDate, value);
                issueDate.sendKeys(Keys.TAB);
                break;
            case  "Кем выдан":
                fillField(issuePlace, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }
    protected void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }


}
