package parser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;

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
    private String adressURL = "http://vpn.unn.ru";

    private String[] logins={"u-1170","u-2043","u-0953","u-1683","u-1727"};
    private String[] passwords={"fawiti","fu6mema","wu3kaco","goru6cu","zeka6ta"};
    //private String curLogin;
    public ArrayList<String> money= new ArrayList<>();
    public ArrayList<String> traffic= new ArrayList<>();
    public ArrayList<String> isEnableFuturePay= new ArrayList<>();
    public HtmlUnitDriver driver;
    public WebDriverWait driverWait;
    public WebDriver driver2;
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
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);
        driver = new HtmlUnitDriver();
        driver.setJavascriptEnabled(true);
        driver.get(this.getURL());
        driverWait = new WebDriverWait(driver,10);

    }
    public void setSetting()
    {
        System.setProperty("webdriver.chrome.driver", "/chromedriver_win32/chromedriver.exe");
        driver2 = new ChromeDriver();
        driver.get(this.getURL());
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


    public void sendMessageAPIVK(String textMessage) throws IOException {
        VkApi vk = new VkApi("5953885","618598d6fed704eb457f0de8535a0cebc5033c39f1cb31116ab182cd9149f396533d6994e528e2772b6db&expires_in=86400&user_id=24665764");
        vk.sendMessage(textMessage,"24665764");
    }

    public void setCurLogin()
    {
       // this.viewMoney();
        for (int i =0;i<5;i++)
            if (Double.parseDouble(money.get(i)) > 0)
            {
                curLogin.setLogin(logins[i]);
                curLogin.setIndex(i);
            }
    }
    //for test
    public void setForcedtCurLogin()//for tests
    {
                curLogin.setLogin(logins[0]);
                curLogin.setIndex(0);

    }

    public void noticeAboutOverMoney() throws IOException {
        if (Double.parseDouble(money.get(curLogin.getIndex()))<15)
        {
            VkApi vk = new VkApi("5953885","618598d6fed704eb457f0de8535a0cebc5033c39f1cb31116ab182cd9149f396533d6994e528e2772b6db&expires_in=86400&user_id=24665764");
vk.sendMessage("Заканчиваются деньги на "+curLogin.getLogin()+ " текущий счёт="+money.get(curLogin.getIndex()),"24665764");
           // sendMessageAPIVK();
        }
    }
}
