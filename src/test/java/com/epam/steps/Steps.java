package com.epam.steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import com.epam.driver.DriverSingleton;
import com.epam.pages.LoginPage;

public class Steps {

	private WebDriver driver;

	public void startBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public boolean loginGitHub(String login, String pass) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(login, pass);
		return loginPage.isError();
	}

	public boolean pressSignIn() throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.clicker();
		TimeUnit.SECONDS.sleep(3);
		return loginPage.isError();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}
}
