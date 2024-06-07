package com.ian.project.test.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ian.project.locators.PlanItContactLocators;
import com.ian.project.pages.PlanItContactPage;
import com.ian.project.pages.PlanItHomePage;
import com.ian.project.utils.HelperUtil;

public class PlanItSteps {
	
	private WebDriver driver;
	private HelperUtil util;

	public PlanItSteps(WebDriver driver) {
		this.driver = driver;
		this.util = new HelperUtil(driver);
	}
	
	public void goToContacts() throws InterruptedException {
		PlanItHomePage.getContactElement(driver).click();
		util.waitForPageToLoad();
	}
	
	public void submitContact() {
		PlanItContactPage.getContactSubmit(driver).click();
	}

	public String getMainErrorMessage() {
		return PlanItContactPage.getMainErrorMessage(driver).getText();
	}
	
	public String getForeNameErrorMessage() {
		return PlanItContactPage.getForeNameErrorMessage(driver).getText();
	}
	
	public String getEmailErrorMessage() {
		return PlanItContactPage.getEmailErrorMessage(driver).getText();
	}
	
	public String getMessageErrorMessage() {
		return PlanItContactPage.getMessageErrorMessage(driver).getText();
	}

	public void populateRequiredFieldsOnContact() {
		util.waitForElementToBeVisible(By.id(PlanItContactLocators.TXTBOX_FORENAME_ID), 10);
		PlanItContactPage.getForeName(driver).sendKeys("Ian");
		PlanItContactPage.getEmail(driver).sendKeys("sample@email.com");
		PlanItContactPage.getMessage(driver).sendKeys("sample message here");
	}

	public boolean checkForeNameError() {
		return util.isElementPresent(By.id(PlanItContactLocators.TXT_FORENAME_ERRORMSG_ID), 2);
	}
	
	public boolean checkEmailError() {
		return util.isElementPresent(By.id(PlanItContactLocators.TXT_EMAIL_ERRORMSG_ID), 2);
	}
	
	public boolean checkMessageError() {
		return util.isElementPresent(By.id(PlanItContactLocators.TXT_MESSAGE_ERRORMSG_ID), 2);
	}

	public String getValidFeedbackMessage() {
		return PlanItContactPage.getValidFeedbackMessage(driver).getText();
	}

	public boolean checkValidFeedbackMessage() {
		util.waitForElementToBeVisible(By.xpath(PlanItContactLocators.TXT_SUCCESSBANNERMSG_XPATH), 5);
		return util.isElementPresent(By.id(PlanItContactLocators.TXT_SUCCESSBANNERMSG_XPATH), 10);
	}

	public boolean checkSubmittingFeedbackBanner() {
		util.waitForElementToBeVisible(By.xpath(PlanItContactLocators.IMG_SENDINGFEEDBACK_XPATH), 5);
		return util.isElementPresent(By.id(PlanItContactLocators.IMG_SENDINGFEEDBACK_XPATH), 10);
	}

}
