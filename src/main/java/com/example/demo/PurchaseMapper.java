package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseMapper {

	List<Purchase> findAll();

	Purchase findOne(int id);

	int getTotalPrice();

	void save(Purchase purchase);

	void update(Purchase purchase);

	void delete(int id);
}
