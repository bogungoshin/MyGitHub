package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

	private final String URL = "https://github.com/login";

	@FindBy(id = "login_field")
	private WebElement inputLogin;

	@FindBy(id = "password")
	private WebElement inputPassword;

	@FindBy(xpath = "//input[@value='Sign in']")
	private WebElement buttonSubmit;

	@FindBy(id = "js-flash-container")
	private WebElement error;

	@Override
	public void openPage() {
		driver.navigate().to(URL);
	}

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void login(String login, String pass) {
		driver.navigate().to(URL);
		inputLogin.sendKeys(login);
		inputPassword.sendKeys(pass);
		buttonSubmit.click();
	}

	public void clicker() {
		buttonSubmit.click();
	}

	public boolean isError() {
		if (error.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
}
