package ru.aplana.secondHomeWork;

import org.junit.Test;
import util.pagesSber.TravelPage;
import util.pagesSber.MainPage;
import util.pagesSber.CalcPage;


import static ru.aplana.secondHomeWork.BaseTest.baseUrl;
import static ru.aplana.secondHomeWork.BaseTest.driver;

/**
 * Created by Sergey
 */
public class RefactorSberTest extends BaseTest{


    @Test

    public void newSberTest(){

        driver.get(baseUrl);
        MainPage mainPage=new MainPage(driver);
        mainPage.selectMainMenu("Застраховать себя");
        mainPage.selectMainMenu("и имущество");
        mainPage.selectSubMenu("Страхование путешественников");

        new TravelPage(driver).sendButton.click();


        CalcPage calcPage=new CalcPage();
        calcPage.testSberbank(driver);
        calcPage.clickMinSum();
        calcPage.clickSendNext();

        calcPage.fillField("Фамилия","Иванонв");
        calcPage.fillField("Имя","Иван");
    }

}
