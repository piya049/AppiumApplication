package runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "/AppiumApplicatiom/src/test/java/features" }, glue = { "stepdefinations",
		"utility", "runner", "pom" }, tags = "@appiumAutomation", plugin = { "pretty", "html:target/appiumApplication" })
@Test
public class TestRunner extends AbstractTestNGCucumberTests {

}
