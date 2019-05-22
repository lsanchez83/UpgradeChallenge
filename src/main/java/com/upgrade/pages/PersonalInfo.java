package com.upgrade.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.upgrade.io.methods.*;
import com.upgrade.setup.PropertyCollections;

import io.codearte.jfairy.producer.person.Person;

public class PersonalInfo {

	public PersonalInfo() {

		PageFactory.initElements(PropertyCollections.driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\'root\']/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[1]/div[1]/div[1]/div/div/div/div/input")
	public WebElement FirstNameTxt;

	@FindBy(how = How.XPATH, using = "//*[@id=\'root\']/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[1]/div[1]/div[2]/div/div/div/div/input")
	public WebElement LastNameTxt;

	@FindBy(how = How.XPATH, using = "//*[@id=\'root\']/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[1]/div[2]/div/div/div/div/div/div/div[1]/input")
	public WebElement StreetTxt;

	@FindBy(how = How.XPATH, using = "//*[@id=\'root\']/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[1]/div[3]/div[1]/div/div/div/div/input")
	public WebElement CityTxt;

	@FindBy(how = How.XPATH, using = "//*[@id=\'root\']/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[1]/div[2]/div/div/div/div/div/div/div[2]/ul/li[1]/span")
	public WebElement StreetClk;

	@FindBy(how = How.XPATH, using = "//*[@id=\'root\']/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[1]/div[4]/div/div/div/input")
	public WebElement DateOfBirthTxt;

	@FindBy(how = How.XPATH, using = "//*[@id=\'root\']/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[1]/div[5]/div/div/div/input")
	public WebElement yearlyIncomeTxt;

	@FindBy(how = How.XPATH, using = "//*[@id=\'root\']/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[1]/div[6]/div/div/div/input")
	public WebElement AdditionalIncomeTxt;

	@FindBy(how = How.XPATH, using = "//*[@id=\'root\']/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[2]/div[1]/div/div/div/input")
	public WebElement EmailTxt;

	@FindBy(how = How.XPATH, using = "//*[@id=\'root\']/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[2]/div[2]/div/div/div/input")
	public WebElement PasswordTxt;

	@FindBy(how = How.XPATH, using = "//*[@id=\'root\']/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[3]/div/label/div[1]")
	public WebElement TermsOfUseChk;

	@FindBy(how = How.XPATH, using = "//*[@id=\'root\']/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[4]/button")
	public WebElement CheckYourRateBtn;

	public void PersonalInformation(Person person, String dob, String email, String yearlyIncome,
			String additionalIncome, String server) throws InterruptedException {

		
		SeleniumTestSetMethods.EnterText(FirstNameTxt, person.getFirstName());
		SeleniumTestSetMethods.EnterText(LastNameTxt, person.getLastName());
		SeleniumTestSetMethods.EnterText(StreetTxt,	person.getAddress().getStreet() + " " + person.getAddress().getStreetNumber());
		Thread.sleep(1000);
		SeleniumTestSetMethods.Clicks(StreetClk);
		if (SeleniumTestGetMethods.GetText(CityTxt).isEmpty()) {
			SeleniumTestSetMethods.EnterText(CityTxt, person.getAddress().getCity());
		}
		SeleniumTestSetMethods.EnterText(DateOfBirthTxt, dob);
		SeleniumTestSetMethods.EnterText(yearlyIncomeTxt, yearlyIncome);
		SeleniumTestSetMethods.EnterText(AdditionalIncomeTxt, additionalIncome);
		SeleniumTestSetMethods.EnterText(EmailTxt, email);
		SeleniumTestSetMethods.EnterText(PasswordTxt, "Passw0rd");
		SeleniumTestSetMethods.Clicks(TermsOfUseChk);
		Thread.sleep(1000);
		SeleniumTestSetMethods.Clicks(CheckYourRateBtn);

	}

}
