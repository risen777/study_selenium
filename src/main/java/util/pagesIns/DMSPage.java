package util.pagesIns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Sergey
 */
public class DMSPage {
    @FindBy(xpath = "//a[contains(text(),'Отправить заявку')]")
   public WebElement sendButton;

    public DMSPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait=new WebDriverWait(driver,5,1000);
      wait.until(ExpectedConditions.visibilityOf(sendButton)).click();
    }

}
