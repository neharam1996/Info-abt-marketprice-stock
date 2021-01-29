package com.tcs.stockinfo.controller;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.stockinfo.model.StockModel;
import com.tcs.stockinfo.service.StockService;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/stock")
public class StockController {
	@Autowired
	StockService stkservice;
	
	@GetMapping("/{symbol}")
	public StockModel getStockInfo(@PathVariable String symbol) throws IOException {
		if(symbol!=null) {
		Stock st1=stkservice.getStock(symbol);
		System.out.println(st1);
		StockModel stkm=stkservice.getStockInfo(st1);
		return stkm;
		}
		else {
			return null;
		}
		
	}
	
	
	
	
}
