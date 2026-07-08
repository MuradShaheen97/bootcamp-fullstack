package com.axsos.SpringBoot.Burger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.SpringBoot.Burger.Models.Burgers;
import com.axsos.SpringBoot.Burger.Services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	
	private final BurgerService burgerSer;

	public BurgerController(BurgerService burgerSer) {
		this.burgerSer = burgerSer;
	}

	// READ ALL & SHOW FORM
	@RequestMapping("/")
	public String index(Model model, @ModelAttribute("burger") Burgers burger) {
		model.addAttribute("burgers", burgerSer.allBurgers());
		return "dashboard";
	}

	// CREATE NEW BURGER
	@PostMapping("/addBurger")
	public String addBurgers(@Valid @ModelAttribute("burger") Burgers burger, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// CRITICAL: Re-populate the list for index.jsp table rendering during validation failure
			model.addAttribute("burgers", burgerSer.allBurgers());
			return "dashboard";
		}
		
		if (burgerSer.addBurger(burger)) {
			return "redirect:/";
		} else {
			// Handle case where custom service-level validation flags false (e.g. name exists)
			model.addAttribute("burgers", burgerSer.allBurgers());
			return "dashboard";
		}
	}

	// RENDER EDIT PAGE
	@GetMapping("/burgers/edit/{id}")
	public String editPage(@PathVariable("id") Long id, Model model) {
		Burgers burger = burgerSer.findBurger(id);
		if (burger != null) {
			model.addAttribute("burger", burger);
			return "edit"; // Standard ViewResolvers assume the suffix .jsp automatically
		}
		return "redirect:/";
	}

	// PROCESS UPDATE FORM
	@PostMapping("/burgers/update/{id}")
	public String updateBurger(@Valid @ModelAttribute("burger") Burgers burger, BindingResult result, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "edit";
		}
		burgerSer.updateBurger(burger, id);
		return "redirect:/";
	}

	// PROCESS DELETE
	@GetMapping("/burgers/delete/{id}")
	public String destroyBurger(@PathVariable("id") Long id) {
		burgerSer.deleteBurger(id);
		return "redirect:/";
	}
}