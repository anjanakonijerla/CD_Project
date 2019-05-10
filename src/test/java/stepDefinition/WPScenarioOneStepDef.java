package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.function.Consumer;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.BrowserInstance;
import utility.PropertiesFileReader;

public class WPScenarioOneStepDef extends BrowserInstance {

	//public static WebDriver driver;
	PropertiesFileReader obj = new PropertiesFileReader();
	String ageHelpText;

	@Given("^Open url and navigate to Westpac KiwiSaver Scheme Retirement Calculator$")
	public void open_url_and_navigate_to_Westpac_KiwiSaver_Scheme_Retirement_Calculator() throws Throwable {
		Properties properties = obj.getProperty();
		BrowserInstance.OpenBrowser(properties.getProperty("browser.name"),
				properties.getProperty("browser.baseURL"));
		/*driver = BrowserInstance.OpenBrowser(driver, properties.getProperty("browser.name"),
				properties.getProperty("browser.baseURL"));*/

		Thread.sleep(3000);
//		WebElement mouseHoverElement = driver.findElement(By.linkText("KiwiSaver"));
//		Actions action = new Actions(driver);
//		WebElement clickElement = driver
//				.findElement(By.xpath("//*[@id=\"ubermenu-item-cta-kiwisaver-calculators-ps\"]"));
//		action.moveToElement(mouseHoverElement).moveToElement(clickElement).click().build().perform();
//
//		driver.findElement(By.linkText("Click here to get started.")).click();
		
		driver.findElement(By.linkText("KiwiSaver")).click();
		driver.findElement(By.xpath("//*[@id=\"ubermenu-item-cta-kiwisaver-calculators-ps\"]")).click();
		driver.findElement(By.linkText("Click here to get started.")).click();
		
		Thread.sleep(3000);
	}

	@When("^User Clicks information icon beside field cuurent age$")
	public String user_Clicks_information_icon_beside_fields() throws Throwable {

		WebElement frame = driver.findElement(By.cssSelector("div#calculator-embed iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//label[text()='Current age']//following::i[1]")).click();
		ageHelpText = driver
				.findElement(By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/div/p"))
				.getText();
		return ageHelpText;
	}

	@Then("^user should be able to see help text \"([^\"]*)\"$")
	public void user_should_be_able_to_see_help_text(String expectedResult) throws Throwable {

		assertEquals(expectedResult, ageHelpText);
		driver.navigate().refresh();
		Thread.sleep(3000);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile //method

			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

			FileUtils.copyFile(src,
					new File("C:\\Users\\visitor\\assigment _Backup\\resultscreens\\" + "Screenshot" + timestamp + ".png"));
		}

		catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}
}
