package com.ian.project.test.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ian.project.test.steps.PlanItSteps;
import com.ian.project.utils.HelperUtil;

public class PlanItTestCases extends TestCase {
	
	private HelperUtil util;
	private PlanItSteps planIt;
	
	@BeforeSuite
	public void setUp() {
		init("http://jupiter.cloud.planittesting.com");
		util = new HelperUtil(driver);
		planIt = new PlanItSteps(driver);
		util.waitForPageToLoad();
	}
	
	@Test
	public void validateErrorMessageOnContact() throws InterruptedException {
		
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
	public void validateSuccessfulFeedbackSubmission() throws InterruptedException {
		util.waitForPageToLoad();
		planIt.goToContacts();
		planIt.populateRequiredFieldsOnContact();
		planIt.submitContact();
		
		Assert.assertTrue(planIt.checkSubmittingFeedbackBanner());
		Assert.assertTrue(planIt.checkValidFeedbackMessage());
		String expectedMessage = "we appreciate your feedback";
		String actualMessage = planIt.getValidFeedbackMessage();
		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void validatePricesOfPurchasedProducts() throws InterruptedException {
		util.waitForPageToLoad();
		planIt.goToShop();
		
		planIt.buyItem("Stuffed Frog", 2);
		planIt.buyItem("Fluffy Bunny", 5);
		planIt.buyItem("Valentine Bear", 3);
		
		planIt.goToCart();
		
		// subtotals
		String expectedValue = planIt.getItemSubTotal("Stuffed Frog");
		String actualValue = planIt.getActualItemSubTotal("Stuffed Frog");
		Assert.assertEquals(actualValue, expectedValue);
		
		expectedValue = planIt.getItemSubTotal("Fluffy Bunny");
		actualValue = planIt.getActualItemSubTotal("Fluffy Bunny");
		Assert.assertEquals(actualValue, expectedValue);
		
		expectedValue = planIt.getItemSubTotal("Valentine Bear");
		actualValue = planIt.getActualItemSubTotal("Valentine Bear");
		Assert.assertEquals(actualValue, expectedValue);
		
		// individual prices
		expectedValue = planIt.getItemPrice("Fluffy Bunny");
		actualValue = planIt.getActualItemPrice("Fluffy Bunny");
		Assert.assertEquals(actualValue, expectedValue);
		
		expectedValue = planIt.getItemSubTotal("Valentine Bear");
		actualValue = planIt.getActualItemSubTotal("Valentine Bear");
		Assert.assertEquals(actualValue, expectedValue);
		
		expectedValue = planIt.getItemSubTotal("Valentine Bear");
		actualValue = planIt.getActualItemSubTotal("Valentine Bear");
		Assert.assertEquals(actualValue, expectedValue);
		
		// total
		expectedValue = planIt.getCartTotal();
		actualValue = planIt.getActualCartTotal();
		Assert.assertEquals(actualValue, expectedValue);
	}

}
