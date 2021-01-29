package com.tcs.stockinfo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.stockinfo.model.StockModel;
import com.tcs.stockinfo.service.StockService;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
@WebMvcTest(StockController.class)
class StockControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired 
	private ObjectMapper objectMapper; 
	
	@MockBean
	private StockService stockservice;
	
	
	@Test
	void testgetStockInfo() throws Exception {
		Stock m1= stockservice.getStock("API");
		String symbol="API";
		StockModel saved=new StockModel("Agora, Inc.","API",new BigDecimal(54.33));
		Mockito.when(stockservice.getStockInfo(m1)).thenReturn(saved);
		String url="/stock/"+symbol;
		MvcResult mvcresult=mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
		String response=mvcresult.getResponse().getContentAsString();
		System.out.println(response);
		
	}

}
