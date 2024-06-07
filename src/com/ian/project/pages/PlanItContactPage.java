package com.ian.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ian.project.locators.PlanItContactLocators;

public class PlanItContactPage {
	
	public static WebElement getContactSubmit(final WebDriver driver) {
		return driver.findElement(By.xpath(PlanItContactLocators.BTN_SUBMIT_XPATH));
	}
	
	public static WebElement getForeName(final WebDriver driver) {
		return driver.findElement(By.id(PlanItContactLocators.TXTBOX_FORENAME_ID));
	}
	
	public static WebElement getEmail(final WebDriver driver) {
		return driver.findElement(By.id(PlanItContactLocators.TXTBOX_EMAIL_ID));
	}
	
	public static WebElement getMessage(final WebDriver driver) {
		return driver.findElement(By.id(PlanItContactLocators.TXTBOX_MESSAGE_ID));
	}

	public static WebElement getMainErrorMessage(WebDriver driver) {
		return driver.findElement(By.xpath(PlanItContactLocators.TXT_ERRORBANNERMSG_XPATH));
	}

	public static WebElement getForeNameErrorMessage(WebDriver driver) {
		return driver.findElement(By.id(PlanItContactLocators.TXT_FORENAME_ERRORMSG_ID));
	}
	
	public static WebElement getEmailErrorMessage(WebDriver driver) {
		return driver.findElement(By.id(PlanItContactLocators.TXT_EMAIL_ERRORMSG_ID));
	}
	
	public static WebElement getMessageErrorMessage(WebDriver driver) {
		return driver.findElement(By.id(PlanItContactLocators.TXT_MESSAGE_ERRORMSG_ID));
	}

	public static WebElement getValidFeedbackMessage(WebDriver driver) {
		return driver.findElement(By.xpath(PlanItContactLocators.TXT_SUCCESSBANNERMSG_XPATH));
	}

	public static WebElement getSendingFeedbackLoader(WebDriver driver) {
		return driver.findElement(By.xpath(PlanItContactLocators.IMG_SENDINGFEEDBACK_XPATH));
	}
	
}
