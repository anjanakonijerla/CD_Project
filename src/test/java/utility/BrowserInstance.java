package utility;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserInstance
{
	public static WebDriver driver;
	
	public static void OpenBrowser(String browserName,String url) throws InterruptedException, Throwable
	{
		
		PropertiesFileReader obj = new PropertiesFileReader();
		if(browserName.equals("Chrome"))
		{
			Properties proobj = obj.getProperty();
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\visitor\\assigment\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(proobj.getProperty("browser.baseURL"));
			Thread.sleep(5000);
			//return driver;	
		}
			//return null;			
	}
	
	/*public static WebDriver OpenBrowser(WebDriver driver,String browserName,String url) throws InterruptedException, Throwable
	{
		
		PropertiesFileReader obj = new PropertiesFileReader();
		if(browserName.equals("Chrome"))
		{
			Properties proobj = obj.getProperty();
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\visitor\\assigment\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(proobj.getProperty("browser.baseURL"));
			Thread.sleep(5000);
			return driver;	
		}
			return null;			
	}*/

}