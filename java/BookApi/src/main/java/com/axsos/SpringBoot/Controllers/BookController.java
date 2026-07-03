package com.axsos.SpringBoot.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axsos.SpringBoot.Models.Books;
import com.axsos.SpringBoot.Services.BookService;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // READ ALL ENDPOINT: Handles HTTP GET requests to fetch all books
    // Testing URL in browser: http://localhost:8080/api/books
    @GetMapping("/api/books")
    public List<Books> index() {
        return bookService.allBooks();
    }

    // CREATE ENDPOINT: Handles HTTP POST requests to create a new book
    @PostMapping("/api/books")
    public Books create(
            @RequestParam(value="title") String title,
            @RequestParam(value="description") String desc,
            @RequestParam(value="language") String lang,
            @RequestParam(value="pages") Integer numOfPages) {

        return bookService.createBook(title, desc, lang, numOfPages);
    }

    // READ ONE ENDPOINT: Handles HTTP GET requests to find a specific book by ID
    @GetMapping("/api/books/{id}")
    public Books show(@PathVariable("id") Long id) {
        return bookService.findBook(id);
    }
}