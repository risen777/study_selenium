package ru.aplana.secondLesson;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Sergey
 */
public class InsuranceTest extends BaseTest {




    @Test
    @Ignore
    public void testInsurance() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//ol[contains(@class,'rgs-menu')]/li/*[contains(text(),'Страхование')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'rgs-main-menu-category')]//a[contains(text(),'ДМС')]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        WebElement sendBtn = driver.findElement(By.xpath("//a[contains(text(),'Отправить заявку')]"));
        wait.until(ExpectedConditions.visibilityOf(sendBtn)).click();
        WebElement title = driver.findElement(By.xpath("//h4[@class='modal-title']"));


        wait.until(ExpectedConditions.visibilityOf(title));
        Assert.assertEquals("Заявка на добровольное медицинское страхование", title.getText());
        fillField(By.name("LastName"), "Иванов");
        fillField(By.name("FirstName"), "Иван");
        fillField(By.name("MiddleName"), "Иванович");


        new Select(driver.findElement(By.name("Region"))).selectByVisibleText("Москва");
        fillField(By.name("Comment"), "Avtotest");
        fillField(By.name("Email"), "1111");


        driver.findElement(By.xpath("//input[@class='checkbox']")).click();
        driver.findElement(By.id("button-m")).click();


        Assert.assertEquals("Иванов",
                driver.findElement(By.name("LastName")).getAttribute("value"));
        Assert.assertEquals("Иван",
                driver.findElement(By.name("FirstName")).getAttribute("value"));
        Assert.assertEquals("Иванович",
                driver.findElement(By.name("MiddleName")).getAttribute("value"));
        Assert.assertEquals("Введите адрес электронной почты",
                driver.findElement(By.xpath("//*[text()='Эл. почта']/..//span[@class='validation-error-text']")).getText());
        String expected = "Введите адрес электронной почты";
        String actual = driver.findElement(By.xpath("//*[text()='Эл. почта']/..//span[@class='validation-error-text']")).getText();
        Assert.assertTrue("Полученное сообщение об ошибке не соответствует ожидаемому   ", expected.equals(actual));
    }


    protected   void  fillField(By locator,String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);

    }
protected  void checkFillField(String value,By locator){

        Assert.assertEquals(value,driver.findElement(locator).getAttribute("value"));
}



}
