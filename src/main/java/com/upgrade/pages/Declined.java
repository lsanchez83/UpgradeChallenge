package com.upgrade.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.upgrade.io.methods.*;
import com.upgrade.setup.PropertyCollections;

public class Declined {

	public Declined() {

		PageFactory.initElements(PropertyCollections.driver, this);

	}

	@FindBy(how = How.XPATH, using = "//*[@id=\'root\']/div/main/div/header/div/nav/label")
	public WebElement MenuBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\'root\']/div/main/div/header/div/nav/ul/li[2]/a")
	public WebElement SignOutBtn;

	

	public void SignOut() {

		SeleniumTestSetMethods.Clicks(MenuBtn);
		SeleniumTestSetMethods.Clicks(SignOutBtn);
	}

}