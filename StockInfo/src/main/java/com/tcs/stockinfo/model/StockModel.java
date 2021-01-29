package com.tcs.stockinfo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;
import yahoofinance.Stock;
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockModel {
	
	private String name;
	@Id
	private String symbol;
	
	private BigDecimal price;
	
	
	
	
}
