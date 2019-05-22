package com.upgrade.io.methods;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTestSetMethods {

	// EnterText
	public static void EnterText(WebElement element, String value) {
		element.sendKeys(value);
	}

	// Click into button, CheckBox, opcion etc
	public static void Clicks(WebElement element) {
		element.click();
	}

	// Selecting DropDown control
	public static void SelectDropDown(WebElement element, String value) {

		new Select(element).selectByVisibleText(value);
	}

	public static void SelectDropDownRand(WebElement element) {

		Select mySelectElement = new Select(element);
		List<WebElement> validSelectOptions = mySelectElement
				.getOptions()
				.stream()
				.filter(p -> !p.getAttribute("value").equals("-1")).collect(Collectors.toList());
		Random rand = new Random();
		WebElement chosenElement = validSelectOptions.get(rand.nextInt(validSelectOptions.size()));
		mySelectElement.selectByValue(chosenElement.getAttribute("value"));

	}
}
