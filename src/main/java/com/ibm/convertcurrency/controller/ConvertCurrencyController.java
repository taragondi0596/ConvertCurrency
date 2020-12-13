package com.ibm.convertcurrency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.convertcurrency.dto.ConvertCurrencyDTO;
import com.ibm.convertcurrency.service.CurrencyConverterService;

@RequestMapping("currencyConverter")
@RestController
public class ConvertCurrencyController {
	
	@Autowired
	CurrencyConverterService converterService;
	
	@PostMapping("/converter/")
	public Double convertCurrency(@RequestBody ConvertCurrencyDTO dto) {
		
		return converterService.convertCurrency(dto);
	}
}
