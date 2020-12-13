package com.ibm.convertcurrency.dto;

public class ConvertCurrencyDTO {
	
	private String countryCode;
	
	private int amount;


	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
}
