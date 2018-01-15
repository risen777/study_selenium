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
public class sberbankTest {
InsuranceTest insuranceTest=new InsuranceTest();
WebDriver driver;
String baseUrl;


@Before
public void beforeTest(){
    System.setProperty("webdriver.chrome.driver","drv/chromedriver.exe");
    driver=new ChromeDriver();
    baseUrl="http://www.sberbank.ru/ru/person";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get(baseUrl);




}



@Test
    public  void  testSberbank(){
driver.findElement(By.xpath("//span[@class='multiline']//*[contains(text(),'Застраховать себя')]")).click();
driver.findElement(By.xpath("//div[contains(@class,'sbrf-div-list-inner --area bp-area header_more_nav')]//a[contains(text(),'Страхование путешественников')]")).click();
    Wait<WebDriver> wait =new WebDriverWait(driver,5,1000);
    WebElement title=driver.findElement(By.xpath("//div[@class='sbrf-rich-outer']//h1[contains(text(),'Страхование путешественников')]"));


    wait.until(ExpectedConditions.visibilityOf(title));
    Assert.assertEquals("Страхование путешественников",title.getText());






//after
        insuranceTest.afterTest();
    }

}
