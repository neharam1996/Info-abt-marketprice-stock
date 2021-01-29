package com.tcs.stockinfo.service;


import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import com.tcs.stockinfo.model.StockModel;
import com.tcs.stockinfo.repository.StockRepository;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;





@RunWith(MockitoJUnitRunner.class)
public class StockServiceTest {

	@InjectMocks
	StockService stkservice;
	@Mock
	private StockRepository stockrepo;
	
	

	

	@Test
	public void testGetStock() throws IOException {
		Stock google=YahooFinance.get("GOOG");
		assertNotNull(google);
		assertEquals("Alphabet Inc.",google.getName());
		
	}

@Test
public void testGetStockInfo() throws IOException {
		Stock stock=YahooFinance.get("NAKD");
	
		StockModel model=new StockModel(stock.getName(),stock.getSymbol(),stock.getQuote().getPrice());
		stkservice.getStockInfo(stock);
		StockModel stk1=stockrepo.findBySymbol("NAKD");
		verify(stockrepo,times(1)).save(model);
	}

}

