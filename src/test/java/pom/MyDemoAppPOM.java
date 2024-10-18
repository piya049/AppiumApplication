package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumBy;


public class MyDemoAppPOM {

	
	WebDriver driver;

	
	public MyDemoAppPOM(WebDriver driver) {
		this.driver = driver;
	}

	By hamburger = By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView");
	By login = AppiumBy.accessibilityId("menu item log in");
	By userName = AppiumBy.accessibilityId("Username input field");
	By pass = AppiumBy.accessibilityId("Password input field");
	By btnLogin = AppiumBy.accessibilityId("Login button");
	
	
	public void clickOnHampburgericon() throws InterruptedException {

		driver.findElement(hamburger).click();
	}

	public void clickOnLogin() {
		driver.findElement(login).click();
	}

	public void clickOnLoginDetails(String GivenName, String password) {
		driver.findElement(userName).sendKeys(GivenName);
		driver.findElement(pass).sendKeys(password);
		
	}

	public void tapOnLoginButton() {

		driver.findElement(btnLogin).click();
	}

	

}
