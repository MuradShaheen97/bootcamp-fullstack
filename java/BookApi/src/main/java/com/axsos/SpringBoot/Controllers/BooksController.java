package com.axsos.SpringBoot.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axsos.SpringBoot.Models.Books;
import com.axsos.SpringBoot.Services.BookService;
@Controller
public class BooksController {

	private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
    @RequestMapping("/books/{id}")
    public String showBooks(@PathVariable("id") Long id,Model model){
    	model.addAttribute("book", bookService.findBook(id));
    	 
        return "show" ;
    }
}
