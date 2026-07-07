package com.axsos.savetravelssavetravels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.axsos.savetravelssavetravels.models.Expense;
import com.axsos.savetravelssavetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {

	private final ExpenseService expenseService;

	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}

	@GetMapping("/")
	public String redirect() {
		return "redirect:/expenses";
	}

	@GetMapping("/expenses")
	public String index(Model model, @ModelAttribute("expense") Expense expense) {
		model.addAttribute("expenses", expenseService.allExpenses());
		return "index";
	}

	@PostMapping("/expenses")
	public String create(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			model.addAttribute("expenses", expenseService.allExpenses());
			return "index";
		}

		expenseService.createExpense(expense);
		return "redirect:/expenses";
	}

	@GetMapping("/expenses/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenseService.findExpense(id));
		return "show";
	}

	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenseService.findExpense(id));
		return "edit";
	}

	@PutMapping("/expenses/{id}")
	public String update(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result) {

		if (result.hasErrors()) {
			return "edit";
		}

		expenseService.updateExpense(expense);
		return "redirect:/expenses";
	}

	@DeleteMapping("/expenses/{id}")
	public String delete(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
}