package com.tcs.stockinfo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@SpringBootApplication
public class StockInfoApplication {
	
	public static void main(String[] args) throws IOException {
		 
		SpringApplication.run(StockInfoApplication.class, args);
		
	}

}
