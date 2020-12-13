package com.ibm.convertcurrency.service;

import org.springframework.stereotype.Service;

import com.ibm.convertcurrency.dto.ConvertCurrencyDTO;
import com.ibm.convertcurrency.restclient.ManageCurrencyConvClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CurrencyConverterService {
	
	final ManageCurrencyConvClient manageCurrencyConvClient;
	
	public CurrencyConverterService(ManageCurrencyConvClient manageCurrencyConvClient) {
		this.manageCurrencyConvClient = manageCurrencyConvClient;
	}
	
	@HystrixCommand(fallbackMethod = "manageCurrencyFallback")
	public Double convertCurrency(ConvertCurrencyDTO dto) {
		
		String countryCode = dto.getCountryCode();
		
		Double convFactor = manageCurrencyConvClient.getCurrencyConversion1(countryCode);

		return (dto.getAmount()/convFactor);
	}
	
	public Double manageCurrencyFallback(ConvertCurrencyDTO dto) {
		
		Double convFactor = 100.0;
		//hard coded convFactor for now but in real time we may hav to look for another service 
		//which manages currency conversion factors
		//or read from a backup table etc
		
		return (dto.getAmount()/convFactor);
		
	}

}
