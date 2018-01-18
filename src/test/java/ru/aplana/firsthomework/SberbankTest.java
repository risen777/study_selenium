package ru.aplana.firsthomework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public void testSberbank() {

        driver.findElement(By.xpath("//span[@class='multiline']//*[contains(text(),'Застраховать себя')]")).click();
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


        fillField(By.name("insured0_surname"), "Ivanov");
        fillField(By.name("insured0_name"), "Ivan");
        fillField(By.name("surname"), "01.01.1991");

        fillField(By.name("name"), "Иван");
        fillField(By.name("surname"), "Иванов");
        fillField(By.name("middlename"), "Иванович");
        fillField(By.name("birthDate"), "02.02.1992");

      driver.findElement(By.xpath("//*[contains(text(),'Пол')]/..//*[contains(@class,'b-radio-field b-checked-radio-field')]")).click();
        fillField(By.name("passport_series"), ("2222"));
        fillField(By.name("passport_number"), ("222233"));
        fillField(By.name("issueDate"), "02.01.2018");
        fillField(By.name("issuePlace"), ("ОВД"));

        driver.findElement(By.xpath("//*[contains(text(),'Продолжить')]")).click();

        Assert.assertEquals("Заполнены не все обязательные поля",
                driver.findElement(By.xpath("//div[@class='b-form-center-pos b-form-error-message']//*[contains(text(),'Заполнены не все обязательные поля')]")).getText());
    }


     public  void  fillField(By locator,String value) {
         driver.findElement(locator).clear();
         driver.findElement(locator).sendKeys(value);
     }
    @After
    public void afterTest() {
        driver.quit();
    }

}
