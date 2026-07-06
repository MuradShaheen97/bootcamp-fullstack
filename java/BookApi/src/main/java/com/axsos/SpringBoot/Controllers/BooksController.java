package com.axsos.SpringBoot.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.SpringBoot.Models.Books;
import com.axsos.SpringBoot.Services.BookService;

import jakarta.validation.Valid;

@Controller
public class BooksController {

	private final BookService bookService;

	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}

	// ---- READ ALL ----
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("books", bookService.allBooks());
		return "index";
	}

	// ---- READ ONE ----
	@GetMapping("/books/{id}")
	public String showBooks(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookService.findBook(id));
		return "show";
	}

	// ---- CREATE NEW BOOK (FORM) ----
	@GetMapping("/addBook")
	public String addBook(@ModelAttribute("book") Books book) {
		return "addBook";
	}

	// ---- CREATE NEW BOOK (PROCESS) ----
	@PostMapping("/addingBook")
	public String addingBook(@Valid @ModelAttribute("book") Books book, BindingResult result) {
		if (result.hasErrors()) {
			return "addBook";
		}
		bookService.createBook(book);
		return "redirect:/";
	}

	// ---- EDIT BOOK (FORM) ----
	@GetMapping("/updateBook/{id}")
	public String updateBook(@PathVariable("id") Long id, Model model) {
		Books existingBook = bookService.findBook(id);
		model.addAttribute("book", existingBook);
		return "addBook";
	}

	// ---- EDIT BOOK (PROCESS) ----
	@PostMapping("/updatingBook/{id}")
	public String updatingBook(
		@Valid @ModelAttribute("book") Books book, 
		BindingResult result, 
		@PathVariable("id") Long id,
		Model model
	) {
		if (result.hasErrors()) {
			// CRITICAL: Ensure the book object retains its ID in the model 
			// so the form action URL /updatingBook/${book.id} doesn't break on re-render
			book.setId(id); 
			return "addBook";
		}
		
		bookService.updateBook(id, book);
		return "redirect:/";
	}
}