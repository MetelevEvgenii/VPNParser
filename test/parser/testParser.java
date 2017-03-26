package parser;

import org.junit.Test;
import org.openqa.selenium.By;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by Evgenii on 25.03.2017.
 */
public class testParser {
    @Test
    public void checkAdressURL()
    {
        Parser parser = new Parser();
        assertEquals("http://vpn.unn.ru",parser.getURL());
    }

    @Test
    public void checkTitleOnVPN()
    {
        Parser parser = new Parser();
        parser.setSetting();
        parser.clickOnStat();
        assertEquals("http://vpn.unn.ru/stat/",parser.driver.getCurrentUrl());
        parser.closeDriver();
    }
    @Test
    public void logInOnVPN1170()
    {
        Parser parser = new Parser();
        parser.setSetting();
        parser.clickOnStat();
        parser.writeLogin(parser.getLogin1());
        parser.writePassword(parser.getPassword1());
        parser.clickLogin();
        assertEquals("Общие",parser.driver.findElement(By.xpath(parser.mainMenuTextXPATH)).getText());
        parser.closeDriver();
    }
    @Test
    public void logInNotRight()
    {
        Parser parser = new Parser();
        parser.setSetting();
        parser.clickOnStat();
        parser.writeLogin("1");
        parser.writePassword("1");
        parser.clickLogin();
        assertEquals("Вход в личный кабинет",parser.driver.findElement(By.xpath(parser.mainMenuTextXPATH)).getText());
        parser.closeDriver();
    }

    @Test
    public void checkMoneyOn()
    {
        Parser parser = new Parser();
        parser.setSetting();
        parser.clickOnStat();
        parser.writeLogin(parser.getLogin1());
        parser.writePassword(parser.getPassword1());
        parser.clickLogin();
        parser.viewMoney();
        assertEquals("-101.18",parser.money.get(0));
        parser.closeDriver();
    }
    @Test
    public void checkTrafficOn()
    {
        Parser parser = new Parser();
        parser.setSetting();
        parser.clickOnStat();
        parser.writeLogin(parser.getLogin1());
        parser.writePassword(parser.getPassword1());
        parser.clickLogin();
        parser.clickOnReport();
        assertEquals("46211.028562546",parser.traffic.get(0));
        parser.closeDriver();
    }

    @Test
    public void isOnPageISNO()
    {
        Parser parser = new Parser();
        parser.setSetting();
        parser.clickOnStat();
        parser.writeLogin(parser.getLogin1());
        parser.writePassword(parser.getPassword1());
        parser.clickLogin();
        parser.clickOnfuturePay();
        assertEquals("no",parser.isEnableFuturePay.get(0));
        parser.closeDriver();
    }

    @Test
    public void isOnPageISYES()
    {
        Parser parser = new Parser();
        parser.setSetting();
        parser.clickOnStat();
        parser.writeLogin(parser.getLogin3());
        parser.writePassword(parser.getPassword3());
        parser.clickLogin();
        parser.clickOnfuturePay();
        assertEquals("yes",parser.isEnableFuturePay.get(0));
        parser.closeDriver();
    }

    @Test
    public void writeResults()
    {
        Parser parser = new Parser();
        parser.setSettingHTML();
        parser.clickOnStat();
        parser.writeLogin(parser.getLogin1());
        parser.writePassword(parser.getPassword1());
        parser.clickLogin();
        parser.viewMoney();
        parser.clickOnReport();
        parser.clickOnObshee();
        parser.clickOnfuturePay();
        parser.clickOnExit();

        parser.writeLogin(parser.getLogin2());
        parser.writePassword(parser.getPassword2());
        parser.clickLogin();
        parser.viewMoney();
        parser.clickOnReport();
        parser.clickOnObshee();
        parser.clickOnfuturePay();
        parser.clickOnExit();


        parser.writeLogin(parser.getLogin3());
        parser.writePassword(parser.getPassword3());
        parser.clickLogin();
        parser.viewMoney();
        parser.clickOnReport();
        parser.clickOnObshee();
        parser.clickOnfuturePay();
        parser.clickOnExit();

        parser.writeLogin(parser.getLogin4());
        parser.writePassword(parser.getPassword4());
        parser.clickLogin();
        parser.viewMoney();
        parser.clickOnReport();
        parser.clickOnObshee();
        parser.clickOnfuturePay();
        parser.clickOnExit();


        parser.writeLogin(parser.getLogin5());
        parser.writePassword(parser.getPassword5());
        parser.clickLogin();
        parser.viewMoney();
        parser.clickOnReport();
        parser.clickOnObshee();
        parser.clickOnfuturePay();
        parser.clickOnExit();

        parser.closeDriver();
        System.out.print(parser.getLogin1()+"    Денег:"+parser.money.get(0)+
                "      Трафика:"+parser.traffic.get(0)+"   Есть обещанный?:"+parser.isEnableFuturePay.get(0));
        System.out.println();

        System.out.print(parser.getLogin2()+"    Денег:"+parser.money.get(1)+
                "      Трафика:"+parser.traffic.get(1)+"   Есть обещанный?:"+parser.isEnableFuturePay.get(1));
        System.out.println();

        System.out.print(parser.getLogin3()+"    Денег:"+parser.money.get(2)+
                "      Трафика:"+parser.traffic.get(2)+"   Есть обещанный?:"+parser.isEnableFuturePay.get(2));
        System.out.println();

        System.out.print(parser.getLogin4()+"    Денег:"+parser.money.get(3)+
                "      Трафика:"+parser.traffic.get(3)+"   Есть обещанный?:"+parser.isEnableFuturePay.get(3));
        System.out.println();

        System.out.print(parser.getLogin5()+"    Денег:"+parser.money.get(4)+
                "      Трафика:"+parser.traffic.get(4)+"   Есть обещанный?:"+parser.isEnableFuturePay.get(4));
        System.out.println();
    }
    @Test
    public void writeResultsTestHtml()
    {
        Parser parser = new Parser();
        parser.setSettingHTML();
        parser.clickOnStat();
        parser.writeLogin(parser.getLogin1());
        parser.writePassword(parser.getPassword1());
        parser.clickLogin();
        parser.viewMoney();
        parser.clickOnReport();
        parser.clickOnObshee();
        parser.clickOnfuturePay();
        parser.closeDriver();
        System.out.print(parser.getLogin1()+"    Денег:"+parser.money.get(0)+
                "      Трафика:"+parser.traffic.get(0)+"   Есть обещанный?:"+parser.isEnableFuturePay.get(0));
        System.out.println();
    }

    @Test
    public void writeAllResultsTestHtml()
    {
        Parser parser = new Parser();
        parser.setSettingHTML();
        parser.clickOnStat();
        parser.writeLogin(parser.getLogin1());
        parser.writePassword(parser.getPassword1());
        parser.clickLogin();
        parser.viewMoney();
        parser.clickOnReport();
        parser.clickOnObshee();
        parser.clickOnfuturePay();
        parser.clickOnExit();

        parser.writeLogin(parser.getLogin2());
        parser.writePassword(parser.getPassword2());
        parser.clickLogin();
        parser.viewMoney();
        parser.clickOnReport();
        parser.clickOnObshee();
        parser.clickOnfuturePay();
        parser.clickOnExit();

        parser.writeLogin(parser.getLogin3());
        parser.writePassword(parser.getPassword3());
        parser.clickLogin();
        parser.viewMoney();
        parser.clickOnReport();
        parser.clickOnObshee();
        parser.clickOnfuturePay();
        parser.clickOnExit();

        parser.writeLogin(parser.getLogin4());
        parser.writePassword(parser.getPassword4());
        parser.clickLogin();
        parser.viewMoney();
        parser.clickOnReport();
        parser.clickOnObshee();
        parser.clickOnfuturePay();
        parser.clickOnExit();

        parser.writeLogin(parser.getLogin5());
        parser.writePassword(parser.getPassword5());
        parser.clickLogin();
        parser.viewMoney();
        parser.clickOnReport();
        parser.clickOnObshee();
        parser.clickOnfuturePay();
        parser.clickOnExit();

        parser.closeDriver();
        System.out.print(parser.getLogin1()+"    Денег:"+parser.money.get(0)+
                "      Трафика:"+parser.traffic.get(0)+"   Есть обещанный?:"+parser.isEnableFuturePay.get(0));
        System.out.println();

        System.out.print(parser.getLogin2()+"    Денег:"+parser.money.get(1)+
                "      Трафика:"+parser.traffic.get(1)+"   Есть обещанный?:"+parser.isEnableFuturePay.get(1));
        System.out.println();

        System.out.print(parser.getLogin3()+"    Денег:"+parser.money.get(2)+
                "      Трафика:"+parser.traffic.get(2)+"   Есть обещанный?:"+parser.isEnableFuturePay.get(2));
        System.out.println();

        System.out.print(parser.getLogin4()+"    Денег:"+parser.money.get(3)+
                "      Трафика:"+parser.traffic.get(3)+"   Есть обещанный?:"+parser.isEnableFuturePay.get(3));
        System.out.println();

        System.out.print(parser.getLogin5()+"    Денег:"+parser.money.get(4)+
                "      Трафика:"+parser.traffic.get(4)+"   Есть обещанный?:"+parser.isEnableFuturePay.get(4));
        System.out.println();


    }
}
