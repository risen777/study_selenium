package ru.aplana.secondLesson;

import org.junit.Test;
import util.pages.DMSPage;
import util.pages.MainPage;
import util.pages.SendAppPage;

/**
 * Created by Sergey
 */
public class MyRefactoringTest extends BaseTest  {

    @Test

    public void newInsuranceTest(){
        driver.get(baseUrl);
        MainPage mainPage=new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("ДМС");

        new DMSPage(driver).sendButton.click();

        SendAppPage sendAppPage=new SendAppPage(driver);
        sendAppPage.fillField("Фамилия","Иванонв");
        sendAppPage.fillField("Имя","Иван");
    }

}
