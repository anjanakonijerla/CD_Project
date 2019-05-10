package stepDefinition;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.BrowserInstance;
import utility.PropertiesFileReader;

public class WPScenarioTwoStepDef extends BrowserInstance {
	// public static WebDriver driver;
	PropertiesFileReader obj = new PropertiesFileReader();

	@Given("^I have a fields with following details$")
	public void i_have_a_fields_with_following_details(DataTable dt) throws Throwable {

		// Properties properties = obj.getProperty();
		// driver = BrowserInstance.OpenBrowser(driver,
		// properties.getProperty("browser.name"),
		// properties.getProperty("browser.baseURLtwo"));
		// Thread.sleep(3000);
		// WebElement frame = driver.findElement(By.cssSelector("div#calculator-embed
		// iframe"));
		// driver.switchTo().frame(frame);
		// // Write code here that turns the phrase above into concrete actions
		// // For automatic transformation, change DataTable to one of
		// // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// // E,K,V must be a scalar (String, Integer, Date, enum etc)

		List<Map<String, String>> list = dt.asMaps(String.class, String.class);

		// find element by xpath for age field and pass age value from input data table
		if (list.get(0).get("age") != null) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			WebElement chart = driver.findElement(By.xpath("//label[text()='Current age'])"));

			js.executeScript("arguments[0].scrollIntoView();", chart);

			driver.findElement(By.xpath("//label[text()='Current age']//following::input[1]"))
					.sendKeys(list.get(0).get("age"));
		}
		// find element by xpath for drop down for employement status field and pass
		// option value from input data table
		if (list.get(0).get("employment") != null) {
			String empvalue = list.get(0).get("employment");
			WebElement dropdown = driver.findElement(By.xpath("//label[text()='Employment status']//following::i[1]"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click()", dropdown);
			WebElement empStatusDropDown = driver.findElement(By.xpath(
					"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div/div[2]"));

			List<WebElement> lioptions = empStatusDropDown.findElements(By.tagName("li"));
			for (WebElement lioption : lioptions) {
				if ((lioption.findElement(By.tagName("span")).getText()).equals((list.get(0).get("employment")))) {
					lioption.findElement(By.tagName("span")).click();

				}
			}
		}
		// // find element for salary and pass value from datatable
		//
		// if (list.get(0).get("salary") != null) {
		// driver.findElement(By.xpath(
		// "//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input"))
		// .sendKeys(list.get(0).get("salary"));
		// }

		if (!(list.get(0).get("salary")).isEmpty()) {
			try {
				WebElement testsalary = driver.findElement(By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input"));
				testsalary.sendKeys(list.get(0).get("salary"));
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
			}

		}

		// find element for kiwiwsaver and and select radio button
		if (!(list.get(0).get("kiwisaver")).isEmpty()) {
			try {
				WebElement radioButton = driver.findElement(By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[4]/div/div/div/div[2]/div[1]/div[1]/div/div/div/div"));

				radioButton.click();

				List<WebElement> spans = radioButton.findElements(By.tagName("span"));
				for (WebElement span : spans) {
					if ((span.getText()).equals((list.get(0).get("kiwisaver")))) {
						span.click();
					}
				}
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
			}
		}
		// Find pIR dropdown and pass values
		if (!(list.get(0).get("PIR")).isEmpty()) {
			WebElement pirDropDown;
			WebElement pirStatusDropDown;

			if ((list.get(0).get("salary")).equalsIgnoreCase("Employed")) {
				pirDropDown = driver.findElement(By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[5]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div"));
				pirDropDown.click();

				pirStatusDropDown = driver.findElement(By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[5]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div[2]"));

			}

			else {
				pirDropDown = driver.findElement(By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div"));
				pirDropDown.click();

				pirStatusDropDown = driver.findElement(By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div[2]"));

			}
			List<WebElement> lioptions1 = pirStatusDropDown.findElements(By.tagName("li"));
			for (WebElement lioption1 : lioptions1) {
				if ((lioption1.findElement(By.tagName("span")).getText()).equals((list.get(0).get("PIR")))) {
					lioption1.findElement(By.tagName("span")).click();

				}
			}

		}

		// find element for kiwiwsaver balance and pass value from datatable

		if (list.get(0).get("kiwibalance") != null) {

			// driver.findElement(By.xpath(
			// "//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[7]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input"))
			// .sendKeys(list.get(0).get("kiwibalance"));
			driver.findElement(By.xpath("//label[text()='Current KiwiSaver balance']//following::input[1]"))
					.sendKeys(list.get(0).get("kiwibalance"));

			// driver.findElement(By.xpath("//li//span[text()='"+investorRateVal+"%']"))
		}
		// find element for volunteer and pass value from datatable
		if (list.get(0).get("Voluntary") != null) {

			driver.findElement(By.xpath("//label[text()='Voluntary contributions']//following::input[1]"))
					.sendKeys(list.get(0).get("Voluntary"));
			// driver.findElement(By.xpath(
			// "//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[8]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[1]/div/input"))
			// .sendKeys(list.get(0).get("Voluntary"));
		}
		// find dropdown for frequency and pass value from datatable

		if (!(list.get(0).get("Frequency")).isEmpty()) {

			WebElement freDropDown;
			WebElement freStatusDropDown;
			if ((list.get(0).get("salary")).equalsIgnoreCase("Employed")) {
				freDropDown = driver.findElement(By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[8]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/div[1]/div/span"));
				freDropDown.click();

				freStatusDropDown = driver.findElement(By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[8]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/div[2]"));
			} else {
				freDropDown = driver.findElement(By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[6]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/div[1]/div/span"));
				freDropDown.click();

				freStatusDropDown = driver.findElement(By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[6]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/div[2]"));

			}
			// WebElement ul2 = freStatusDropDown.findElement(By.tagName("ul"));
			List<WebElement> lioptions2 = freStatusDropDown.findElements(By.tagName("li"));
			for (WebElement lioption2 : lioptions2) {

				if ((lioption2.findElement(By.tagName("span")).getText()).equals((list.get(0).get("Frequency")))) {
					lioption2.findElement(By.tagName("span")).click();

				}
			}
		}
		//
		// find element for risk radio button and pass value from data table
		if (!(list.get(0).get("profile")).isEmpty()) {
			WebElement radioButton;
			if ((list.get(0).get("salary")).equalsIgnoreCase("Employed")) {

				radioButton = driver.findElement(By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[9]/div/div/div/div[2]/div[1]/div[1]/div/div/div"));

				radioButton.click();
			}

			else {
				radioButton = driver.findElement(By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[7]/div/div/div/div[2]/div[1]/div[1]/div/div/div"));

				radioButton.click();
			}
			List<WebElement> spans = radioButton.findElements(By.tagName("span"));
			for (WebElement span : spans) {
				if ((span.getText()).equals((list.get(0).get("profile")))) {
					span.click();
				}
			}
		}

		// find element for goals and pass value from data table
		if (!(list.get(0).get("goal")).isEmpty()) {

			driver.findElement(By.xpath("//label[text()='Savings goal at retirement']//following::input[1]"))
					.sendKeys(list.get(0).get("goal"));
			// driver.findElement(By.xpath(
			// "//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[10]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input"))
			// .sendKeys(list.get(0).get("goal"));
		}
	}

	@When("^user clicks on view projection$")
	public void user_clicks_on_view_projection() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button//span[text()='View your KiwiSaver retirement projections']")).click();
	}

	@Then("^user should be able to see his projected balances at retirement$")
	public void user_should_be_able_to_see_his_projected_balances_at_retirement() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		String result = driver.findElement(By.className("results-heading")).getText();
		assertTrue(result.contains("your KiwiSaver balance is estimated to be"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement chart = driver.findElement(By.className("results-heading"));

		js.executeScript("arguments[0].scrollIntoView();", chart);
		// Take screenshot and store as a file format
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
		
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

}
