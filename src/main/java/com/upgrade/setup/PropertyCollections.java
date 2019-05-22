package com.upgrade.setup;

import org.openqa.selenium.WebDriver;

public class PropertyCollections {

	public static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		PropertyCollections.driver = driver;
	}

}
