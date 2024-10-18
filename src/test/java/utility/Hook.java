package utility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

	private static WebDriver driver;
	public AppiumDriverLocalService service;
	
	@Before("@appiumAutomation")
	public void setUpAppium() throws MalformedURLException {

		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Pshende//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options  options = new UiAutomator2Options();
		options.setDeviceName("PixelEmulator");
		options.setApp("D://AppiumApplicatiom//resources//Android-MyDemoAppRN.1.3.0.build-244.apk"); 
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	}

	@After
	public void tearDown() {
		driver.quit();
		service.stop();
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
}
