package stepDefinition;


import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.PropertiesFileReader;

public class SmokeTest {
	
	public static WebDriver driver;
	PropertiesFileReader obj = new PropertiesFileReader();

	@Given("^Open firefox and start credentials$")
	public void open_firefox_and_start_credentials() throws Throwable {
		Properties proobj = obj.getProperty();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akonijerla\\eclipse-workspace\\com.automation\\BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	//	System.out.println(proobj.getProperty("browser.baseURL"));
		driver.get(proobj.getProperty("browser.baseURL_old"));
	//	driver.get("https://www.facebook.com");
		Thread.sleep(3000);
	}

	@When("^I enter valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	public void i_enter_valid_and_valid(String arg1, String arg2) throws Throwable {
		driver.findElement(By.id("email")).sendKeys("test@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("testpassword");

	}

	@Then("^user should be able to login succesfully$")
	public void user_should_be_able_to_login_succesfully() throws Throwable {
		driver.findElement(By.id("loginbutton")).click();

	}
}
