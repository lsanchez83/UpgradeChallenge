package com.upgrade.io.methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTestGetMethods {

	public static String GetText(WebElement element) {
		return element.getAttribute("value");
	}

	public static String GetTextFromDDList(WebElement element) {
		return new Select(element).getAllSelectedOptions().toString();
	}
}
