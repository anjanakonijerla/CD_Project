package runner;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import utility.BrowserInstance;
import utility.PropertiesFileReader;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "features" }, glue = { "stepDefinition" }, plugin = { "html:target/cucumber-html-report","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
		"json:target/cucumber.json", "pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
		"junit:target/cucumber-results.xml", "rerun:target/rerun.txt", "html:target/htmlreports" })
public class TestRunner extends BrowserInstance {
	@BeforeClass
	public static void setUP() throws IOException, InterruptedException {
		driver = BrowserInstance.getBrowser("Chrome", 74, "windows");
		driver.get(PropertiesFileReader.getProperty("browser.baseURL"));
		Thread.sleep(3000);
	}

	@AfterClass
	public static void writeExtentReport() {
		driver.quit();
		Reporter.loadXMLConfig(new File("config/report.xml"));
		

	}
}