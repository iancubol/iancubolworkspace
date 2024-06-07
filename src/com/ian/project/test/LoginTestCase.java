package com.ian.project.test;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ian.project.test.steps.LoginSteps;

public class LoginTestCase extends TestCase {
	@BeforeSuite
	public void setUp() {
		init("http://facebook.com/");
	}

	@Test
	public void testLogin() {
		LoginSteps loginStep = new LoginSteps(driver);
		loginStep.login("testuser", "testpassword");
		final String actualTitle = driver.getTitle();
		final String expectedTitle = "Log into Facebook";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
}
