package com.upgrade.util;

public class State {

	private String label;
	private String abbreviation;
	private float minLoanAmount;
	private float minAge;

	// Getter Methods

	public String getLabel() {
		return label;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public float getMinLoanAmount() {
		return minLoanAmount;
	}

	public float getMinAge() {
		return minAge;
	}

	// Setter Methods

	public void setLabel(String label) {
		this.label = label;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public void setMinLoanAmount(float minLoanAmount) {
		this.minLoanAmount = minLoanAmount;
	}

	public void setMinAge(float minAge) {
		this.minAge = minAge;
	}
}
