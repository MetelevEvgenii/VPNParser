package parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//import static junit.framework.TestCase.assertEquals;
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
        parser.setSettingHTML();
        parser.clickOnStat();
        assertEquals("http://vpn.unn.ru/stat/", parser.driver.getCurrentUrl());
        parser.closeDriver();
    }
    @Test
    public void logInOnVPN1170()
    {
        Parser parser = new Parser();
        parser.setSettingHTML();
        parser.clickOnStat();
        parser.writeLogin(parser.getLogin_i(0));
        parser.writePassword(parser.getPassword_i(0));
        parser.clickLogin();
        assertEquals("Общие", parser.getTextByXPATH(parser.mainMenuTextXPATH));
        parser.closeDriver();
    }
    @Test
    public void logInNotRight()
    {
        Parser parser = new Parser();
        parser.setSettingHTML();
        parser.clickOnStat();
        parser.writeLogin("1");
        parser.writePassword("1");
        parser.clickLogin();
        assertEquals("Вход в личный кабинет", parser.getTextByXPATH(parser.mainMenuTextXPATH));
        System.out.println("неверный логин/пароль");
        parser.closeDriver();
    }

    @Test
    public void checkMoneyOn()
    {
        Parser parser = new Parser();
        parser.setSettingHTML();
        parser.clickOnStat();
        parser.writeLogin(parser.getLogin_i(0));
        parser.writePassword(parser.getPassword_i(0));
        parser.clickLogin();
        parser.viewMoney();
        assertEquals("-101.18",parser.money.get(0));
        parser.closeDriver();
    }
    @Test
    public void checkTrafficOn()
    {
        Parser parser = new Parser();
        parser.setSettingHTML();
        //parser.setSetting();
        parser.clickOnStat();
        parser.writeLogin(parser.getLogin_i(0));
        parser.writePassword(parser.getPassword_i(0));
        parser.clickLogin();
        parser.clickOnReport();
        assertEquals("46211.028562546",parser.traffic.get(0));
        parser.closeDriver();
    }

    @Test
    public void isOnPageISNo()
    {
        Parser parser = new Parser();
        parser.setSettingHTML();
        parser.clickOnStat();
        parser.writeLogin(parser.getLogin_i(0));
        parser.writePassword(parser.getPassword_i(0));
        parser.clickLogin();
        parser.clickOnfuturePay();
        assertEquals("no",parser.isEnableFuturePay.get(0));
        parser.closeDriver();
    }

    @Test
    public void isOnPageISYES()
    {
        Parser parser = new Parser();
        parser.setSettingHTML();
        parser.clickOnStat();
        parser.writeLogin(parser.getLogin_i(2));
        parser.writePassword(parser.getPassword_i(2));
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

        for (int i=0; i<5;i++)
        {
            parser.writeLogin(parser.getLogin_i(i));
            parser.writePassword(parser.getPassword_i(i));
            parser.clickLogin();
            parser.viewMoney();
            parser.clickOnReport();
            parser.clickOnObshee();
            parser.clickOnfuturePay();
            parser.clickOnExit();
        }
        parser.closeDriver();
        for (int i=0; i<5;i++)
        {
        System.out.print(parser.getLogin_i(i)+"    Денег:"+parser.money.get(i)+
                "      Трафика:"+parser.traffic.get(i)+"   Есть обещанный?:"+parser.isEnableFuturePay.get(i));
        System.out.println();

        }
    }
  /*  @Test
    public void parserSendMessageVK() throws IOException {
        Parser parser = new Parser();
        parser.sendMessageAPIVK("text");
    }
    @Test
    public void checkCurLogin()
    {
        Parser parser = new Parser();
        parser.setSettingHTML();
        parser.clickOnStat();

        for (int i=0; i<5;i++)
        {
            parser.writeLogin(parser.getLogin_i(i));
            parser.writePassword(parser.getPassword_i(i));
            parser.clickLogin();
            parser.viewMoney();
            parser.clickOnReport();
            parser.clickOnObshee();
            parser.clickOnfuturePay();
            parser.clickOnExit();
        }
        parser.closeDriver();
        parser.setCurLogin();
        assertEquals("u-1683",parser.curLogin.getLogin());
    }
    @Test
    public void checkSendRightMessage() throws IOException {
        Parser parser = new Parser();
        parser.setSettingHTML();
        parser.clickOnStat();

        for (int i=0; i<5;i++)
        {
            parser.writeLogin(parser.getLogin_i(i));
            parser.writePassword(parser.getPassword_i(i));
            parser.clickLogin();
            parser.viewMoney();
            parser.clickOnReport();
            parser.clickOnObshee();
            parser.clickOnfuturePay();
            parser.clickOnExit();
        }
        parser.closeDriver();
        parser.setCurLogin();
        parser.noticeAboutOverMoney();
    }
    @Test
    public void checkSendRightMessageMoneyIsOver() throws IOException {
        Parser parser = new Parser();
        parser.setSettingHTML();
        parser.clickOnStat();

        for (int i=0; i<5;i++)
        {
            parser.writeLogin(parser.getLogin_i(i));
            parser.writePassword(parser.getPassword_i(i));
            parser.clickLogin();
            parser.viewMoney();
            parser.clickOnReport();
            parser.clickOnObshee();
            parser.clickOnfuturePay();
            parser.clickOnExit();
        }
        parser.closeDriver();
        parser.setForcedtCurLogin();
        parser.noticeAboutOverMoney();
    }*/
}
