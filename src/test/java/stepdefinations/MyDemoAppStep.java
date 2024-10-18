package stepdefinations;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pom.MyDemoAppPOM;
import utility.ExcelReader;
import utility.Hook;

public class MyDemoAppStep {

	Hook hook;
	WebDriver driver;
	MyDemoAppPOM myDemoApp;

	public MyDemoAppStep() {
		this.driver = Hook.getDriver();
	}

	@Given("User open the application")
	public void user_open_the_application() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("User select the handburger to open menu")
	public void user_select_the_handburger_to_open_menu() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);

		// in step defination you need to initialize the POM Object again
		// for calling the methods other wise it will show you the NoSuchElementFound
		// Exception
		myDemoApp = new MyDemoAppPOM(driver);
		myDemoApp.clickOnHampburgericon();
	}

	@Then("User tap on login")
	public void user_tap_on_login() {
		// Write code here that turns the phrase above into concrete actions
		myDemoApp.clickOnLogin();
	}

	@Then("User try login attempts from {string} and {int}")
	public void user_try_login_attempts_from_and(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData("/AppiumApplicatiom/resources/AppiumApplication.xlsx",
				sheetName);

		// here make sure the column name matched properly otherwise you will get error
		// of null char
		String name = testData.get(rowNumber).get("userName");
		String pass = testData.get(rowNumber).get("pass");

		myDemoApp = new MyDemoAppPOM(driver);
		myDemoApp.clickOnLoginDetails(name, pass);
	}

	@Then("User tap on login button")
	public void user_tap_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		myDemoApp.tapOnLoginButton();
	}

}
