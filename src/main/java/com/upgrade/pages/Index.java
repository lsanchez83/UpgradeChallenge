package com.upgrade.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.upgrade.io.methods.*;
import com.upgrade.setup.PropertyCollections;

public class Index {

		
	public Index() {

		PageFactory.initElements(PropertyCollections.driver, this);
	}

	@FindBy(how = How.NAME, using = "desiredAmount")
	public WebElement LoanAmountTxt;

	@FindBy(how = How.XPATH, using = ".//*[@id=\'root\']/div/main/div/div/div/div/div[2]/div[2]/form/div/div/div[2]/div/select")
	public WebElement LoanPurposeDdl;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'root\']/div/main/div/div/div/div/div[2]/div[2]/form/div/div/div[3]/button")
	public WebElement CheckYourRateBtn;	
	
	@FindBy(how = How.CLASS_NAME, using = "header-nav-menu__btn")
	public WebElement SignBtn;


	public void LoanRate(String amount) throws InterruptedException {		

		
		SeleniumTestSetMethods.EnterText(LoanAmountTxt, amount);
		SeleniumTestSetMethods.SelectDropDownRand(LoanPurposeDdl);		
		SeleniumTestSetMethods.Clicks(CheckYourRateBtn);
	}	
	
}
