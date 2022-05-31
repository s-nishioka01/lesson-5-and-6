package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PurchaseController {

	private PurchaseService purchaseService;

	@Autowired
	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("purchaseList", purchaseService.getPurchaseList());
		model.addAttribute("totalPrice", purchaseService.getTotalPrice());
		return "index";
	}

	@GetMapping("/new")
	public String newPurchase(Model model) {
		LocalDateTime today = LocalDateTime.now();
		model.addAttribute("today", today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		return "new";
	}

	@GetMapping("/update/{id}")
	public String updatePurchase(@PathVariable int id, Model model) {
		model.addAttribute("purchase", purchaseService.findOne(id));
		return "update";
	}

	@GetMapping("/delete/{id}")
	public String deletePurchase(@PathVariable int id, Model model) {
		model.addAttribute("purchase", purchaseService.findOne(id));
		return "delete";
	}

	@PostMapping("/new")
	public String create(@ModelAttribute Purchase purchase) {
		purchaseService.savePurchaseList(purchase);
		return "redirect:/index";
	}

	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, @ModelAttribute Purchase purchase) {
		purchase.setId(id);
		purchaseService.updatePurchaseList(purchase);
		return "redirect:/index";
	}

	@PostMapping("/delete/{id}")
	public String destroy(@PathVariable int id) {
		purchaseService.deletePurchaseList(id);
		return "redirect:/index";
	}

}
