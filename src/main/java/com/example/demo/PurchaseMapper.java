package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseMapper {

	List<Purchase> findAll();

	Optional<Purchase> findOne(int id);

	int getTotalPrice();

	void save(PurchaseForm purchaseForm);

	void update(PurchaseForm purchaseForm);

	void delete(int id);
}
