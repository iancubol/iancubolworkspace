package com.ian.project.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ian.project.locators.PlanItShopLocators;

public class PlanItShopPage {

	private PlanItCartPage cart;
	private Map<String, Double> pricingMap;

	public PlanItShopPage() {
		this.cart = new PlanItCartPage();
		this.pricingMap = new HashMap<>();
		initializeItemPrices();
	}

	private void initializeItemPrices() {
		this.pricingMap.put("Teddy Bear", 12.99);
		this.pricingMap.put("Stuffed Frog", 10.99);
		this.pricingMap.put("Handmade Doll", 10.99);
		this.pricingMap.put("Fluffy Bunny", 9.99);
		this.pricingMap.put("Smiley Bear", 14.99);
		this.pricingMap.put("Funny Cow", 10.99);
		this.pricingMap.put("Valentine Bear", 14.99);
		this.pricingMap.put("Smiley Face", 9.99);
	}

	public void addToCart(String item, int qty) {
		cart.add(item, this.pricingMap.get(item) * qty);
	}
	
	public String getSubTotal(String item) {
		return "$" + cart.getSubTotal(item).toString();
	}
	
	public String getPrice(String item) {
		return "$" + pricingMap.get(item).toString();
	}
	
	public String getTotal() {
		return "Total: " + cart.getTotalAmount().toString();
	}
	
	//elements
	public static WebElement getItemBuyButton(WebDriver driver, String itemName) {
		return driver.findElement(By.xpath(PlanItShopLocators.BTN_BUY_ITEM.replace("itemName", itemName)));
	}
}
