package com.ian.project.test.steps;

import org.openqa.selenium.WebDriver;

import com.ian.project.pages.LoginPage;

public class LoginSteps {

	private WebDriver driver;
	
	public LoginSteps(WebDriver driver) {
		this.driver = driver;
	}

	public void login(final String username, final String password) {
		LoginPage.getUserName(driver).sendKeys(username);
		LoginPage.getPassword(driver).sendKeys(password);
		LoginPage.getLoginButton(driver).click();
	}

}
