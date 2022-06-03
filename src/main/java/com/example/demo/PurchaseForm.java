package com.example.demo;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class PurchaseForm {

	private int id;

	@Length(max = 30, message = "30文字以内で入力してください")
	@NotBlank(message = "商品名が未入力です")
	private String itemName;

	@Range(min = 0, max = 100000000, message = "0~100000000の範囲で入力してください")
	@NotNull(message = "価格が未入力です")
	private int price;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate purchaseDate;

	public PurchaseForm(int id, String itemName, int price, LocalDate purchaseDate) {
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.purchaseDate = purchaseDate;
	}

	public PurchaseForm() {

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
