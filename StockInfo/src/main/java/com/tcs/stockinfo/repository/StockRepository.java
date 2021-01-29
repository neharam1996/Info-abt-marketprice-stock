package com.tcs.stockinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tcs.stockinfo.model.StockModel;

@Repository
public interface StockRepository extends CrudRepository<StockModel, String> {
 public StockModel findBySymbol(String name);
}
