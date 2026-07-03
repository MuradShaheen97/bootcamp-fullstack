package com.axsos.BooksAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.BooksAPI.models.Books;
import com.axsos.BooksAPI.repositories.BooksRepository;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Books> allBooks() {
        return booksRepository.findAll();
    }

    public Books createBook(Books book) {
        return booksRepository.save(book);
    }

    public Books findBook(Long id) {
        Optional<Books> optionalBook = booksRepository.findById(id);
        return optionalBook.orElse(null);
    }

    public Books updateBook(Long id, String title, String description, String language, Integer pages) {
        Optional<Books> optionalBook = booksRepository.findById(id);

        if (optionalBook.isPresent()) {
            Books book = optionalBook.get();

            book.setTitle(title);
            book.setDescription(description);
            book.setLanguage(language);
            book.setPages(pages);

            return booksRepository.save(book);
        }

        return null;
    }

    public void deleteBook(Long id) {
        booksRepository.deleteById(id);
    }
}