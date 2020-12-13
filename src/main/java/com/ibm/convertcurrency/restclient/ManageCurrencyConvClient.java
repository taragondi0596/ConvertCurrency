package com.ibm.convertcurrency.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@FeignClient(name="manage-currency")
public interface ManageCurrencyConvClient {
	
	@GetMapping("/manageCurr/{countryCode}")
	public Double getCurrencyConversion1(@RequestParam(value="countryCode")String countryCode);

}
