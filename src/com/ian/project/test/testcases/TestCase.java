package com.ian.project.test.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class TestCase {
	protected ChromeDriver driver;

	public void init(final String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);;
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
