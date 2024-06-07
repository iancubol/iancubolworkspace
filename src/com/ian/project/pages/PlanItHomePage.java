package com.ian.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlanItHomePage {
	
	public static WebElement getContactElement(final WebDriver driver) {
		return driver.findElement(By.xpath("//a[@href='#/contact']"));
	}
	
}
