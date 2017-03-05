package com.epam.driver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

	private static WebDriver driver;
	private static final String WEBDRIVER = "webdriver.gecko.driver";
	private static final String GECKODRIVER_EXE = ".\\geckodriver\\geckodriver.exe";

	private DriverSingleton() {

	}

	public static WebDriver getDriver() {
		if (null == driver) {
			System.setProperty(WEBDRIVER, GECKODRIVER_EXE);
			driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}
		return driver;
	}

	public static void closeDriver() {
		driver.quit();
		driver = null;
	}
}
