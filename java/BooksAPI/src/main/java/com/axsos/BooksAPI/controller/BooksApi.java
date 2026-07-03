package com.axsos.BooksAPI.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.axsos.BooksAPI.models.Books;
import com.axsos.BooksAPI.services.BooksService;

@RestController
public class BooksApi {

    private final BooksService booksService;

    public BooksApi(BooksService booksService) {
        this.booksService = booksService;
    }

    @RequestMapping("/api/books")
    public List<Books> index() {
        return booksService.allBooks();
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public Books create(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("language") String language,
            @RequestParam("pages") Integer pages) {

        Books book = new Books(title, description, language, pages);
        return booksService.createBook(book);
    }

    @RequestMapping("/api/books/{id}")
    public Books show(@PathVariable("id") Long id) {
        return booksService.findBook(id);
    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
    public Books update(
            @PathVariable("id") Long id,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("language") String language,
            @RequestParam("pages") Integer pages) {

        return booksService.updateBook(id, title, description, language, pages);
    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        booksService.deleteBook(id);
    }
}