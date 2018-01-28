package ru.aplana.firstHomeWork;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sergey
 */
public class SberbankTest {


    WebDriver driver;
    String baseUrl;


    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);


    }


    @Test

    @Ignore
    public void testSberbank() {
        driver.findElement(By.xpath("//span[@class='multiline']//*[contains(text(),'Застраховать себя')]")).click();
        driver.findElement(By.xpath("//span[@class='multiline']//*[contains(text(),'и имущество')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'sbrf-div-list-inner --area bp-area header_more_nav')]//a[contains(text(),'Страхование путешественников')]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        WebElement title = driver.findElement(By.xpath("//div[@class='sbrf-rich-outer']//h1[contains(text(),'Страхование путешественников')]"));


        wait.until(ExpectedConditions.visibilityOf(title));
        Assert.assertEquals("Страхование путешественников", title.getText());
//driver.findElement(By.xpath("//li[@class='active']//*[contains(text(),'Оформить онлайн')]")).click();
        driver.findElement(By.xpath("//*/img[contains(@src, 'banner-zashita-traveler.jpg')]")).click();

        while (!driver.getTitle().equals("Сбербанк страхование")) {
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
        }

        WebElement title2 = driver.findElement(By.xpath("//*[text()='Регион действия полиса']"));
        wait.until(ExpectedConditions.visibilityOf(title2));
        driver.findElement(By.xpath("//div[contains(text(),'Минимальная')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Оформить')]")).click();
//driver.findElement(By.xpath("//li[@class='b-tabset-style ng-isolate-scope disabled']/..//span[contains(text(),'Оформление')]")).click();

///Ввод
        fillField(By.name("insured0_surname"), "Ivanov");
        fillField(By.name("insured0_name"), "Ivan");


        fillField(By.name("name"), "Иван");
        fillField(By.name("surname"), "Петров");
        fillField(By.name("middlename"), "Иванович");
        fillField(By.name("birthDate"), "02.02.1992");

        driver.findElement(By.xpath("//*[contains(text(),'Пол')]/..//*[contains(@class,'b-radio-field b-checked-radio-field')]")).click();
        fillField(By.name("passport_series"), ("2222"));
        fillField(By.name("passport_number"), ("222233"));
        fillField(By.name("issueDate"), "02.01.2018");
        fillField(By.name("issuePlace"), ("ОВД"));

        driver.findElement(By.xpath("//*[contains(text(),'Продолжить')]")).click();

////Проверка заполнения
        Assert.assertEquals("Ivanov",
                driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        Assert.assertEquals("Ivan",
                driver.findElement(By.name("insured0_name")).getAttribute("value"));
        Assert.assertEquals("Иван",
                driver.findElement(By.name("name")).getAttribute("value"));
        Assert.assertEquals("Петров",
                driver.findElement(By.name("surname")).getAttribute("value"));

        Assert.assertEquals("Иванович",
                driver.findElement(By.name("middlename")).getAttribute("value"));
        Assert.assertEquals("02.02.1992",
                driver.findElement(By.name("birthDate")).getAttribute("value"));

        Assert.assertEquals("2222",
                driver.findElement(By.name("passport_series")).getAttribute("value"));
        Assert.assertEquals("222233",
                driver.findElement(By.name("passport_number")).getAttribute("value"));
        Assert.assertEquals("02.01.2018",
                driver.findElement(By.name("issueDate")).getAttribute("value"));
        Assert.assertEquals("ОВД",
                driver.findElement(By.name("issuePlace")).getAttribute("value"));


       /* Assert.assertEquals("Заполнены не все обязательные поля",
                driver.findElement(By.xpath("//div[@class='b-form-center-pos b-form-error-message']//*[contains(text(),'Заполнены не все обязательные поля')]")).getText());
        private boolean isElementPresent(By by) {*/

        Assert.assertTrue("Заполнены не все обязательные поля", isElementPresent(By.xpath("//div [text()='Заполнены не все обязательные поля']")));

    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }


    @After
    public void afterTest() {
        driver.quit();
    }

}
