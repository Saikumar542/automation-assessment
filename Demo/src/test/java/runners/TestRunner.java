package runners;

import org.junit.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "C:\\Users\\saiku\\Music\\Assinment\\automation-assessment\\Demo\\src\\test\\resources\\features",
		glue = "stepdefinitions",
		plugin = {"pretty", "html:target/cucumber-report.html"},
		monochrome = true
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	@Test
	public void runCucumberTests() {

	}
}
