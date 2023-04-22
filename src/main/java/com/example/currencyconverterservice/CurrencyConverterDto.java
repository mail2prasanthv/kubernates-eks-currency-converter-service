package com.example.currencyconverterservice;

public class CurrencyConverterDto {
	private String fromCurrency;
	private String toCurrency;
	private double rate;
	
	public CurrencyConverterDto() {
		super();
	}

	public CurrencyConverterDto(String fromCurrency, String toCurrency, double rate) {
		super();
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.rate = rate;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
