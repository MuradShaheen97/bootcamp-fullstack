package com.axsos.SpringBoot.Controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axsos.SpringBoot.Models.Books;
import com.axsos.SpringBoot.Services.BookService;

@RestController
public class BookController {
    
    private final BookService bookService;

    // Dependency Injection linking your BookService
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // CREATE ENDPOINT: Handles HTTP POST requests to create a new book
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public void create(
            @RequestParam(value="title") String title,
            @RequestParam(value="description") String desc,
            @RequestParam(value="language") String lang,
            @RequestParam(value="pages") Integer numOfPages) {
        
        // Calls your service layer's creation method
        bookService.createBook(title, desc, lang, numOfPages);
    }

    // UPDATE ENDPOINT: Handles HTTP PUT requests to update an existing book
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Books update(
            @PathVariable("id") Long id,
            @RequestParam(value="title") String title,
            @RequestParam(value="description") String desc, 
            @RequestParam(value="language") String lang,     
            @RequestParam(value="pages") Integer numOfPages) { 
        
        return bookService.updateBook(id, title, desc, lang, numOfPages);
    }

    // DELETE ENDPOINT: Handles HTTP DELETE requests to remove a book
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}
