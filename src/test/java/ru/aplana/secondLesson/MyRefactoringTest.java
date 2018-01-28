package ru.aplana.secondLesson;

import org.junit.Ignore;
import org.junit.Test;
import util.pagesIns.DMSPage;
import util.pagesIns.MainPage;
import util.pagesIns.SendAppPage;

/**
 * Created by Sergey
 */
public class MyRefactoringTest extends BaseTest  {

    @Test
    @Ignore
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
