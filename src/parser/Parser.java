package parser;

import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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



   /* private String login1 = "u-1170";
    private String password1 = "fawiti";

    private String login2 = "u-2043";
    private String password2 = "fu6mema";

    private String login3 = "u-0953";
    private String password3 = "wu3kaco";

    private String login4 = "u-1683";
    private String password4 = "goru6cu";

    private String login5 = "u-1727";
    private String password5 = "zeka6ta";*/

    public ArrayList<String> money= new ArrayList<>();
    public ArrayList<String> traffic= new ArrayList<>();
    public ArrayList<String> isEnableFuturePay= new ArrayList<>();
    public HtmlUnitDriver driver;
    public WebDriverWait driverWait;
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
   /* public void setSetting()
    {
        System.setProperty("webdriver.chrome.driver", "/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(this.getURL());
        driverWait = new WebDriverWait(driver,10);
    }*/
    public void clickOnStat()
    {
        //driver.findElement(By.xpath(StatButtonXPATH)).click();
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
        //driver.findElement(By.xpath(loginButtonXPATH)).click();
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
        this.traffic.add(this.driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(reportIncomingMBXPATH))).getText());

    }
    public void clickOnfuturePay()
    {
        //driver.findElement(By.xpath(futurePaidButtonXPATH)).click();
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

  /*  public String getLogin2() {
        return login2;
    }

    public String getPassword2() {
        return password2;
    }

    public String getLogin3() {
        return login3;
    }

    public String getPassword3() {
        return password3;
    }*/
    public void clickOnObshee()
    {
        //driver.findElement(By.xpath(obsheeXPATH)).click();
        this.clickByXPATH(obsheeXPATH);
    }
    public void clickOnExit()
    {
        //driver.findElement(By.xpath(exitButtonXPATH)).click();
        this.clickByXPATH(exitButtonXPATH);
    }

  /*  public String getLogin4() {
        return login4;
    }

    public String getPassword4() {
        return password4;
    }

    public String getLogin5() {
        return login5;
    }

    public String getPassword5() {
        return password5;
    }*/
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
}
