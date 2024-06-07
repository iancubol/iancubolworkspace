package com.ian.project.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ian.project.locators.PlanItCartLocators;

public class PlanItCartPage {

	private Map<String, Double> cart;
	
	public PlanItCartPage() {
		cart = new HashMap<>();
	}

	public void add(String item, Double subTotal) {
		cart.put(item, subTotal);
	}
	
	public Double getTotalAmount() {
		return cart.values().stream().mapToDouble(d -> d).sum();
	}

	public Double getSubTotal(String item) {
		return cart.get(item);
	}
	
	// elements
	public static WebElement getItemSubTotal(WebDriver driver, String itemName) {
		return driver.findElement(By.xpath(PlanItCartLocators.TXT_ITEM_SUBTOTAL.replace("itemName", itemName)));
	}

	public static WebElement getItemPrice(WebDriver driver, String itemName) {
		return driver.findElement(By.xpath(PlanItCartLocators.TXT_ITEM_PRICE.replace("itemName", itemName)));
	}

	public static WebElement getCartTotal(WebDriver driver) {
		return driver.findElement(By.xpath(PlanItCartLocators.TXT_TOTAL));
	}

}
