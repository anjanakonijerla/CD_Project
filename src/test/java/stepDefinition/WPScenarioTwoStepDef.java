package stepDefinition;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.BrowserUtils;
import utility.PropertiesFileReader;

public class WPScenarioTwoStepDef {
	public static WebDriver driver;
	PropertiesFileReader obj = new PropertiesFileReader();

	@Given("^I have a fields with following details$")
	public void i_have_a_fields_with_following_details(DataTable dt) throws Throwable {

		Properties properties = obj.getProperty();
		driver = BrowserUtils.OpenBrowser(driver, properties.getProperty("browser.name"),
				properties.getProperty("browser.baseURLtwo"));
		Thread.sleep(3000);

		WebElement frame = driver.findElement(By.cssSelector("div#calculator-embed iframe"));
		driver.switchTo().frame(frame);
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)

		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		System.out.println(list.get(0).get("age")); // output : 30
		System.out.println(list.get(0).get("employment"));// output :Employed
		System.out.println(list.get(0).get("salary"));// Output : $82000
		// Fetch remaining data using same logic
		driver.findElement(By.xpath(
				"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div[1]/div/div/input"))
				.sendKeys(list.get(0).get("age"));
		String empvalue = list.get(0).get("employment");
		WebElement dropdown = driver.findElement(By.xpath(
				"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div/div[1]/div"));
		dropdown.click();
		
		dropdown.findElement(By.xpath(".//li/span[contains(text(),'Employed')]")).click();
	//	List<WebElement> options = dropdown.findElements(By.tagName("li"));
//		for (WebElement option : options) {
//			if (option.getText().equals(empvalue)) {
//				option.click(); // click the desired option
//				break;
//			}
//		}

	}

	@When("^user clicks on view projection$")
	public void user_clicks_on_view_projection() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("i am in secenrio 2 when");
	}

	@Then("^user should be able to see his projected balances at retirement$")
	public void user_should_be_able_to_see_his_projected_balances_at_retirement() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("i am in secenrio 2 then");
	}

}
