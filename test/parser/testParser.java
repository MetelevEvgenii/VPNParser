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
}
