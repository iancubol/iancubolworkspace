package com.ian.project.test;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ian.project.test.steps.PlanItSteps;
import com.ian.project.utils.HelperUtil;

public class PlanItTestCases extends TestCase {
	
	private HelperUtil util;
	
	@BeforeSuite
	public void setUp() {
		init("http://jupiter.cloud.planittesting.com");
		util = new HelperUtil(driver);
	}
	
	@Test
	public void validateErrorMessageOnContact() throws InterruptedException {
		PlanItSteps planIt = new PlanItSteps(driver);
		planIt.goToContacts();
		planIt.submitContact();
		String expectedErrorMessage = " - but we won't get it unless you complete the form correctly.";
		String actualErrorMessage = planIt.getMainErrorMessage();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
		
		expectedErrorMessage = "Forename is required";
		actualErrorMessage = planIt.getForeNameErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		
		expectedErrorMessage = "Email is required";
		actualErrorMessage = planIt.getEmailErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		
		expectedErrorMessage = "Message is required";
		actualErrorMessage = planIt.getMessageErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		
		planIt.populateRequiredFieldsOnContact();
		Assert.assertFalse(planIt.checkForeNameError());
		Assert.assertFalse(planIt.checkEmailError());
		Assert.assertFalse(planIt.checkMessageError());
	}
	
	@Test
	public void validateSuccessfulContactSubmission() throws InterruptedException {
		PlanItSteps planIt = new PlanItSteps(driver);
		util.waitForPageToLoad();
		planIt.goToContacts();
		planIt.populateRequiredFieldsOnContact();
		planIt.submitContact();
		
		Assert.assertTrue(planIt.checkSubmittingFeedbackBanner());
		Assert.assertTrue(planIt.checkValidFeedbackMessage());
		String expectedErrorMessage = "we appreciate your feedback";
		String actualErrorMessage = planIt.getValidFeedbackMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

}
