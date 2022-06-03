package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PurchaseController {

	private final PurchaseService purchaseService;

	@Autowired
	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("purchaseList", purchaseService.getPurchaseList());
		model.addAttribute("totalPrice", purchaseService.getTotalPrice());
		model.addAttribute("error", "");
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
		try {
			model.addAttribute("purchase", purchaseService.findOne(id));
			return "update";

		} catch (Exception e) {
			model.addAttribute("purchaseList", purchaseService.getPurchaseList());
			model.addAttribute("totalPrice", purchaseService.getTotalPrice());
			model.addAttribute("error", "データが登録されていません");
			return "index";
		}

	}

	@GetMapping("/delete/{id}")
	public String deletePurchase(@PathVariable int id, Model model) {
		try {
			model.addAttribute("purchase", purchaseService.findOne(id));
			return "delete";

		} catch (Exception e) {
			model.addAttribute("purchaseList", purchaseService.getPurchaseList());
			model.addAttribute("totalPrice", purchaseService.getTotalPrice());
			model.addAttribute("error", "データが登録されていません");
			return "index";
		}

	}

	@PostMapping("/new")
	public String create(@Validated @ModelAttribute PurchaseForm purchaseForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "new";
		}
		purchaseService.savePurchaseList(purchaseForm);
		return "redirect:/index";
	}

	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, @Validated @ModelAttribute PurchaseForm purchaseForm,
			BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("purchase", purchaseService.findOne(id));
			model.addAttribute("validationError", errorList);
			return "update";
		}
		purchaseForm.setId(id);
		purchaseService.updatePurchaseList(purchaseForm);
		return "redirect:/index";
	}

	@PostMapping("/delete/{id}")
	public String destroy(@PathVariable int id) {
		purchaseService.deletePurchaseList(id);
		return "redirect:/index";
	}

}
