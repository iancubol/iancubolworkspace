package com.ian.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public static WebElement getUserName(final WebDriver driver) {
		return driver.findElement(By.id("email"));
	}

	public static WebElement getPassword(final WebDriver driver) {
		return driver.findElement(By.id("pass"));
	}

	public static WebElement getLoginButton(final WebDriver driver) {
		return driver.findElement(By.name("login"));
	}
}
