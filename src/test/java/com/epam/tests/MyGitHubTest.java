package com.epam.tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.steps.Steps;

public class MyGitHubTest {

	private final String login = "bogungoshin";
	private final String pass = "lis123456";
	private Steps steps;

	@BeforeMethod(description = "Start Browser")
	public void start() {
		steps = new Steps();
		steps.startBrowser();
	}

	@AfterMethod(description = "Stop Browser")
	public void stop() {
		steps.closeDriver();
	}

	@Test(description = "Correct login and password")
	public void loginRight(){
		steps.loginGitHub(login, pass);
	}

	@Test(description = "Login with the big letter")
	public void loginBigLetterLogin(){
		String loginFail = login.substring(0, 1).toUpperCase() + login.substring(1).toLowerCase();
		steps.loginGitHub(loginFail, pass);
	}

	@Test(description = "Password with the big letter")
	public void loginBigLetterPass(){
		String passFail = pass.substring(0, 1).toUpperCase() + pass.substring(1).toLowerCase();
		steps.loginGitHub(login, passFail);
	}

	@Test(description = "Just to click button SignIn")
	public void pressButtonWithoutLoginPass() throws Exception {
		steps.pressSignIn();
		TimeUnit.SECONDS.sleep(5);
	}
}
