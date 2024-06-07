package com.ian.project.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUtil {

	private WebDriver driver;

	public HelperUtil(WebDriver driver) {
		this.driver = driver;
	}

//	public void waitForElementToBeVisible(WebElement element, long timeout) {
//		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(timeout, TimeUnit.SECONDS)
//				.pollingEvery(300, TimeUnit.MILLISECONDS).ignoring(ElementNotInteractableException.class);
//
//		wait.until(d -> {
//			element.isDisplayed();
//			return true;
//		});
//	}
	
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
        WebDriverWait wait = new WebDriverWait(driver, 120);
        // Wait for page complete
        wait.until(pageLoadCondition);
        // Lower implicitly wait time
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
    }
	
	public void waitForElementToBeVisible(By locator, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
