package parser;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Evgenii on 25.03.2017.
 */
public class Parser {
    public String StatButtonXPATH = "/html/body/center/p[3]/a[1]";
    public String loginFieldXPATH = "/html/body[@class='body']/table/tbody/tr/td[@class='work-area']/form[@class='form']/table/tbody/tr/td/table[@class='layout-cover']/tbody/tr/td/table[@class='layout']/tbody/tr[2]/td[@class='layout-cell'][2]/input[@class='forminput']";
    public String passwordFieldXPATH = "/html/body[@class='body']/table/tbody/tr/td[@class='work-area']/form[@class='form']/table/tbody/tr/td/table[@class='layout-cover']/tbody/tr/td/table[@class='layout']/tbody/tr[3]/td[@class='layout-cell'][2]/input[@class='forminput']";
    public String loginButtonXPATH = "/html/body[@class='body']/table/tbody/tr/td[@class='work-area']/form[@class='form']/table/tbody/tr/td/table[@class='layout-cover']/tbody/tr/td/table[@class='layout']/tbody/tr[4]/td[@class='layout-cell'][2]/input[@class='submit']";
    public String mainMenuTextXPATH = "/html/body[@class='body']/table/tbody/tr/td[@class='menu-area']/div[@class='mainmenu-act']";
    public String moneyXPATH =  "/html/body[@class='body']/table/tbody/tr/td[@class='work-area']/table[@class='utm-table-cover']/tbody/tr/td/table[@class='utm-table']/tbody/tr[4]/td[@class='utm-cell'][2]";
    public String reportButtonXPATH = "/html/body[@class='body']/table/tbody/tr/td[@class='menu-area']/div[@class='mainmenu-inact'][1]/a";
    public String reportLookButtonXPATH =  "/html/body[@class='body']/table/tbody/tr/td[@class='work-area']/form[@class='form']/table/tbody/tr/td/table[@class='layout-cover']/tbody/tr/td/table[@class='layout']/tbody/tr[1]/td[@class='layout-cell'][5]/input";
    public String reportIncomingMBXPATH = "/html/body[@class='body']/table/tbody/tr/td[@class='work-area']/table[@class='utm-table-cover']/tbody/tr/td/table[@class='utm-table']/tbody/tr[2]/td[@class='utm-cell'][2]";
    public String futurePaidButtonXPATH = "/html/body[@class='body']/table/tbody/tr/td[@class='work-area']/table[1]/tbody/tr/td[@class='submenu-area']/span[@class='submenu-inact']/a";
    public String obsheeXPATH =  "/html/body[@class='body']/table/tbody/tr/td[@class='menu-area']/div[@class='mainmenu-inact'][1]/a";
    public String exitButtonXPATH =  "/html/body[@class='body']/table/tbody/tr/td[@class='menu-area']/div[@class='mainmenu-inact'][3]/a/b";
    public String dateOfPaymantXPATH = "/html/body[@class='body']/table/tbody/tr/td[@class='work-area']/table[@class='utm-table-cover']/tbody/tr/td/table[@class='utm-table']/tbody/tr[2]/td[@class='utm-cell'][1]";
    public String btnDateOfPaymant = "/html/body[@class='body']/table/tbody/tr/td[@class='work-area']/table[1]/tbody/tr/td[@class='submenu-area']/span[@class='submenu-inact'][1]/a";
    public String showPaymants = "/html/body[@class='body']/table/tbody/tr/td[@class='work-area']/form[@class='form']/table/tbody/tr/td/table[@class='layout-cover']/tbody/tr/td/table[@class='layout']/tbody/tr[1]/td[@class='layout-cell'][5]/input";
    private String adressURL = "http://vpn.unn.ru";

    private String[] logins={"u-1170","u-2043","u-0953","u-1683","u-1727"};
    private String[] passwords={"fawiti","fu6mema","wu3kaco","goru6cu","zeka6ta"};
    public final String nullString = "00/00/00 00:00";
    public ArrayList<String> money= new ArrayList<>();
    public ArrayList<String> traffic= new ArrayList<>();
    public ArrayList<String> isEnableFuturePay= new ArrayList<>();

    public ChromeDriver driver2;
    public HtmlUnitDriver driver;
    public WebDriverWait driverWait;
    public CurLogin curLogin = new CurLogin();
    public String getURL() {
        return adressURL;
    }
    public String getLogin_i(int i)
    {
        return this.logins[i];
    }
    public String getPassword_i(int i)
    {
        return this.passwords[i];
    }

    public void setSettingHTML()
    {
        driver = new HtmlUnitDriver();
        driver.setJavascriptEnabled(true);
        driver.get(this.getURL());
        driverWait = new WebDriverWait(driver,10);

    }
    public void setSetting()
    {
        System.setProperty("webdriver.chrome.driver", "/chromedriver_win32/chromedriver.exe");
        driver2 = new ChromeDriver();
        driver2.get(this.getURL());
        driverWait = new WebDriverWait(driver,10);
    }
    public void clickOnStat()
    {
        this.clickByXPATH(StatButtonXPATH);
    }

    public void writeLogin(String logIn)
    {
            driver.findElement(By.xpath(loginFieldXPATH)).sendKeys(logIn);
    }
    public void writePassword(String password)
    {
        driver.findElement(By.xpath(passwordFieldXPATH)).sendKeys(password);
    }

    public void clickLogin()
    {
        this.clickWithWaitingByXPATH(loginButtonXPATH);
        if (this.getTextWithWaitingByXPATH(mainMenuTextXPATH).equals("Вход в личный кабинет"))
            return;

    }

    public void viewMoney()
    {
      this.money.add( this.getTextWithWaitingByXPATH(moneyXPATH));
    }

    public void clickOnReport()
    {
        this.clickWithWaitingByXPATH(reportButtonXPATH);
        this.clickWithWaitingByXPATH(reportLookButtonXPATH);
        if (driver.findElement(By.className("work-area")).getText().contains("Нет данных"))
        {
            this.traffic.add("Чистый");
        }
       else {
            this.traffic.add(this.driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(reportIncomingMBXPATH))).getText());
        }
    }
    public void clickOnfuturePay()
    {
        this.clickByXPATH(futurePaidButtonXPATH);
        if (driver.getPageSource().contains("Внести платеж"))
            isEnableFuturePay.add("yes");
        else
            isEnableFuturePay.add("no");

    }

    public void closeDriver()
    {
        driver.quit();
    }

    public void clickOnObshee()
    {
        this.clickByXPATH(obsheeXPATH);
    }
    public void clickOnExit()
    {
        this.clickByXPATH(exitButtonXPATH);
    }


    public String getTextByXPATH(String xpathString)
    {
           return driver.findElement(By.xpath(xpathString)).getText();
    }

    public void clickByXPATH(String xpathString)
    {
         driver.findElement(By.xpath(xpathString)).click();
    }

    public void clickWithWaitingByXPATH(String xpathString)
    {
             driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathString))).click();
    }
    public String getTextWithWaitingByXPATH(String xpathString)
    {
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathString))).getText();
    }

    public int setCurLogin(myOwnDate[] date)
    {
        date = new myOwnDate[logins.length];

        for(int i=0;i<logins.length;i++)
        {
            this.writeLogin(this.getLogin_i(i));
            this.writePassword(this.getPassword_i(i));
            this.clickLogin();

            this.clickWithWaitingByXPATH(reportButtonXPATH);
            this.clickByXPATH(btnDateOfPaymant);
            this.clickByXPATH(showPaymants);
            if (!driver.getPageSource().contains("Нет данных за выбранный период"))
                {
                    String paymant = this.getTextByXPATH(dateOfPaymantXPATH);
                    date[i] = new myOwnDate(paymant);
                }
                else
                {
                    date[i] = new myOwnDate(nullString);// 00000000 если не существует платежа
                }
            this.clickOnExit();
        }
        //sourceDate = date;
        myOwnDate[] sourceDate = Arrays.copyOf(date,logins.length);
        date[0].sortDate(date);

        for(int i=0;i<logins.length;i++)
        {
            if (sourceDate[i].dateString.contains(date[logins.length-1].dateString))
                return i;
        }

        return 0;
    }

    //for test
   /* public void setForcedtCurLogin()//for tests
    {
                curLogin.setLogin(logins[0]);
                curLogin.setIndex(0);
    }*/

}
