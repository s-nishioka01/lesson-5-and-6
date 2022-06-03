package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

	private final PurchaseMapper purchaseMapper;

	@Autowired
	public PurchaseService(PurchaseMapper purchaseMapper) {
		this.purchaseMapper = purchaseMapper;
	}

	public List<Purchase> getPurchaseList() {
		return purchaseMapper.findAll();
	}

	public Purchase findOne(int id) throws Exception {
		return purchaseMapper.findOne(id).orElseThrow(() -> new Exception("データが登録されていません"));
	}

	public int getTotalPrice() {
		return purchaseMapper.getTotalPrice();
	}

	public void savePurchaseList(PurchaseForm purchaseForm) {
		purchaseMapper.save(purchaseForm);
	}

	public void updatePurchaseList(PurchaseForm purchaseForm) {
		purchaseMapper.update(purchaseForm);
	}

	public void deletePurchaseList(int id) {
		purchaseMapper.delete(id);
	}

}