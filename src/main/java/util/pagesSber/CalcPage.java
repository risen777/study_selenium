package util.pagesSber;

import org.junit.Assert;
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

import static org.junit.Assert.assertEquals;


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

    @FindBy(name = "male")
    WebElement sex;

    @FindBy(name = "passport_series")
    WebElement passportSeries;

    @FindBy(name = "passport_number")
    WebElement passportNumber;

    @FindBy(name = "issueDate")
    WebElement issueDate;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "issuePlace")
    WebElement issuePlace;
    @FindBy(xpath = "//DIV[@ng-show='tryNext && myForm.$invalid']")

    public WebElement errorMessage;
    @FindBy(xpath = "//*[contains(text(),'Продолжить')]")
    public WebElement sendButtonNext;



    public void clickMinSum() {
        minSum.click();
    }

    public void clickSendNext() {
        sendNext.click();
    }
    public void clickSex() {
        sex.click();
    }
    public void clicksendButtonNext() {
        sendButtonNext.click();
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
                fillField(sex, "male");
                break;
            case  "Серия паспорта":
                fillField(passportSeries, value);
                break;
            case  "Номер паспорта":
                fillField(passportNumber, value);
                break;
            case  "Дата выдачи":
                fillField(issueDate, value);
                issueDate.sendKeys(Keys.TAB);
                break;
            case  "Кем выдан":
                fillField(issuePlace, value);
                break;
            case  "Электронная почта":
                fillField(email, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    //проверка правильности заполнения

    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Фамилия застрахованного":
                return insLastName.getAttribute("value");
            case  "Имя застрахованного":
                return insFirstName.getAttribute("value");

            case  "Фамилия":
                return lastName.getAttribute("value");

            case  "Имя":
                return firstName.getAttribute("value");

            case  "Отчество":
                return middleName.getAttribute("value");

            case  "Дата рождения":
                return birthDate.getAttribute("value");

            case  "Серия паспорта":
                return passportSeries.getAttribute("value");

            case  "Номер паспорта":
                return passportNumber.getAttribute("value");

            case  "Дата выдачи":
                return issueDate.getAttribute("value");

            case  "Кем выдан":
                return issuePlace.getAttribute("value");
            case  "Электронная почта":
                return issuePlace.getAttribute("value");

        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public  void checkErrorMessage(String InputData){

        assertEquals(InputData,errorMessage.getText());

    }


    protected void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }


}
