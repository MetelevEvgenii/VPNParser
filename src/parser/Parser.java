package parser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    private String adressURL = "http://vpn.unn.ru";
    private String login1 = "u-1170";
    private String password1 = "fawiti";

    public ArrayList<String> money= new ArrayList<String>();

    public WebDriver driver;

    public String getURL() {
        return adressURL;
    }

    public String getLogin1() {
        return login1;
    }

    public String getPassword1() {
        return password1;
    }

    public void setSetting()
    {
        System.setProperty("webdriver.chrome.driver", "/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(this.getURL());

    }
    public void clickOnStat()
    {
        driver.findElement(By.xpath(StatButtonXPATH)).click();
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
        driver.findElement(By.xpath(loginButtonXPATH)).click();
        if (driver.findElement(By.xpath(mainMenuTextXPATH)).getText().equals("Вход в личный кабинет"))
            return;
    }

    public void viewMoney()
    {
      this.money.add( driver.findElement(By.xpath(moneyXPATH)).getText());

    }

    public void closeDriver()
    {
        driver.quit();
    }

}
