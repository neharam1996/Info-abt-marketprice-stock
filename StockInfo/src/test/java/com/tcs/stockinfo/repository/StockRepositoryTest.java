package com.tcs.stockinfo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.tcs.stockinfo.model.StockModel;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
class StockRepositoryTest {

	@Autowired
	private StockRepository stockrepository;
	@Autowired
	private TestEntityManager entityManager;


	@Test
	@Rollback(false)
	void test() throws IOException {
		Stock stock=YahooFinance.get("NAKD");
		StockModel stockmodel=stockrepository.save(new StockModel(stock.getName(),stock.getSymbol(),stock.getQuote().getPrice()));
		
		assertNotNull(stockmodel);	
		assertNotNull(stockrepository.findBySymbol("NAKD"));
		}

	@Test
	void test2() throws IOException {
		Stock stock=YahooFinance.get("API");
		StockModel stockmodel=entityManager.persist(new StockModel(stock.getName(),stock.getSymbol(),stock.getQuote().getPrice()));
		assertThat(stockmodel.getSymbol()).isSameAs(stock.getSymbol());
		
	}
}
