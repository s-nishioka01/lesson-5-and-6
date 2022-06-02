package com.example.demo;

import java.util.List;
import java.util.Optional;

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
		Optional<Purchase> purchaseOptional = purchaseMapper.findOne(id);
		if (purchaseOptional.isPresent() == false) {
			throw new Exception("データが登録されていません");
		}
		Purchase purchase = purchaseOptional.get();
		return purchase;
	}

	public int getTotalPrice() {
		return purchaseMapper.getTotalPrice();
	}

	public void savePurchaseList(Purchase purchase) {
		purchaseMapper.save(purchase);
	}

	public void updatePurchaseList(Purchase purchase) {
		purchaseMapper.update(purchase);
	}

	public void deletePurchaseList(int id) {
		purchaseMapper.delete(id);
	}

}