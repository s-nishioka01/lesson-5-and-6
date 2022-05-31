package com.example.demo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Purchase {

	private int id;

	private String itemName;

	private int price;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate purchaseDate;

	public Purchase(int id, String itemName, int price, LocalDate purchaseDate) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.purchaseDate = purchaseDate;
	}

	public Purchase() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

}
