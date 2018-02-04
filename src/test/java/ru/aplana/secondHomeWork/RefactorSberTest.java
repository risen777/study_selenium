package ru.aplana.secondHomeWork;

import org.junit.Test;
import util.pagesSber.TravelPage;
import util.pagesSber.MainPage;
import util.pagesSber.CalcPage;

/**
 * Created by Sergey
 */
public class RefactorSberTest extends BaseTest {


    @Test

    public void newSberTest() {

        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driver);

        mainPage.selectMainMenu("Застраховать себя");
        mainPage.selectMainMenu("и имущество");
        mainPage.selectSubMenu("Страхование путешественников");

        new TravelPage(driver).sendButton.click();


        CalcPage calcPage=new CalcPage();
        calcPage.testSberbank(driver);
        calcPage.clickMinSum();

        calcPage.clickSendNext();

        calcPage.fillField("Фамилия застрахованного", "Ivanov");
        calcPage.fillField("Имя застрахованного", "Ivan");
        calcPage.fillField("Фамилия", "Петров");
        calcPage.fillField("Имя", "Петр");
        calcPage.fillField("Отчество", "Петрович");
        calcPage.fillField("Дата рождения", "21.01.1991");
        calcPage.clickSex();
        calcPage.fillField("Серия паспорта", "4613");
        calcPage.fillField("Номер паспорта", "112443");
        calcPage.fillField("Дата выдачи", "22.08.2017");
        calcPage.fillField("Кем выдан", "ОВД");
        calcPage.fillField("Электронная почта", "afa@gmail.com");



        calcPage.clicksendButtonNext();
        calcPage.checkField("Фамилия застрахованного", "Ivanov");
        calcPage.checkField("Имя застрахованного", "Ivan");
        calcPage.checkField("Фамилия", "Петров");
        calcPage.checkField("Имя", "Петр");
        calcPage.checkField("Отчество", "Петрович");
        calcPage.checkField("Дата рождения", "21.01.1991");
        calcPage.checkField("Серия паспорта", "4613");
        calcPage.checkField("Номер паспорта", "112443");
        calcPage.checkField("Дата выдачи", "22.08.2017");
        calcPage.checkField("Кем выдан", "ОВД");
        calcPage.checkField("Электронная почта", "afa@gmail.com");
calcPage.checkErrorMessage("Заполнены не все обязательные поля");
    }

}
