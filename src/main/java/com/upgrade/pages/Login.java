package com.upgrade.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.upgrade.io.methods.*;
import com.upgrade.setup.PropertyCollections;

public class Login {

	public Login() {

		PageFactory.initElements(PropertyCollections.driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\'root\']/div/main/div/div/div/div/form/div/div[2]/div/div/div/input")
	public WebElement EmailTxt;

	@FindBy(how = How.XPATH, using = "//*[@id=\'root\']/div/main/div/div/div/div/form/div/div[3]/div/div/div[1]/input")
	public WebElement PasswordTxt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'root\']/div/main/div/div/div/div/form/button")
	public WebElement SignInBtn;	

	public void LoginUpgrade(String email, String password) {
		
		SeleniumTestSetMethods.EnterText(EmailTxt, email);
		SeleniumTestSetMethods.EnterText(PasswordTxt, password);
		SeleniumTestSetMethods.Clicks(SignInBtn);
	}
}
