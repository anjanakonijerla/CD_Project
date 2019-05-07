package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\akonijerla\\eclipse-workspace\\com.automation\\features\\WPScenarioTwo.feature",glue={"stepDefinition"})
public class TestRunner {

}
