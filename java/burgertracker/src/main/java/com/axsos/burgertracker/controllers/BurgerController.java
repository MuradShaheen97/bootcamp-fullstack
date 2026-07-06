package com.axsos.burgertracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.axsos.burgertracker.models.Burger;
import com.axsos.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {

	private final BurgerService burgerService;

	public BurgerController(BurgerService burgerService) {
		this.burgerService = burgerService;
	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("burgers", burgerService.allBurgers());
		model.addAttribute("burger", new Burger());
		return "index.jsp";
	}

	@RequestMapping(value = "/burgers", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("burgers", burgerService.allBurgers());
			return "index.jsp";
		}

		burgerService.createBurger(burger);
		return "redirect:/";
	}
}