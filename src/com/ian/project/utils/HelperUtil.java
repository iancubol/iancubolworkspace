package com.ian.project.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUtil {

	private WebDriver driver;
	protected WebDriverWait wdw;

	public HelperUtil(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isElementPresent(By by, long timeout) {
		boolean isPresent = true;
		waitForPageToLoad();
		// Search for elements and check if list is empty
		if (driver.findElements(by).isEmpty()) {
			isPresent = false;
		}
		// Rise back implicitly wait time
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		return isPresent;
	}

	public void waitForPageToLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {
                // This will tell if page is loaded
                return "complete".equals(((JavascriptExecutor) wd).executeScript("return document.readyState"));
            }
        };
        try {
        	Thread.sleep(2000);
        	WebDriverWait wait = new WebDriverWait(driver, 30);
        	// Wait for page complete
        	wait.until(pageLoadCondition);
        } catch (Throwable error) {
        	System.out.println("Page loading timed out...");
        }
	}

	public void waitForElementToBeVisible2(By locator, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement waitForElementToBeVisible(By locator, int timeout) {
		try {
			this.wdw = new WebDriverWait(driver, timeout);
			this.wdw.withMessage(String.format("Timed out waiting for element {%s} to be visible", locator.toString()));
			this.wdw.pollingEvery(1, TimeUnit.SECONDS);
			return this.wdw.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}

}
