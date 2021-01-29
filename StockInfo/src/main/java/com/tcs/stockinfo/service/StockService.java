package com.tcs.stockinfo.service;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.stockinfo.model.StockModel;
import com.tcs.stockinfo.repository.StockRepository;

import yahoofinance.Stock;
//import yahoofinance.Stock;
import yahoofinance.YahooFinance;
@Service
public class StockService {
	
	@Autowired
	StockRepository stkrepo;
	public Stock getStock(String symbol) throws IOException {
		return YahooFinance.get(symbol.toUpperCase());
	}
	
	public StockModel getStockInfo(Stock stock) {
		if(stock!=null) {
		try {
		StockModel stm=new StockModel(stock.getName(),stock.getSymbol(),stock.getQuote().getPrice());
		stkrepo.save(stm);
		return stm;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}}
		else {
			return null;
		}
	}
	
	

}
