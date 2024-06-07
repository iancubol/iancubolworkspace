package com.ian.project.locators;

public class PlanItCartLocators {
	public static final String TXT_ITEM_SUBTOTAL = "//td[contains(text(),'itemName')]/parent::tr/td[4]";
	public static final String TXT_ITEM_PRICE = "//td[contains(text(),'itemName')]/parent::tr/td[2]";
	public static final String TXT_TOTAL = "//td/strong[contains(@class, 'total')]";
}
