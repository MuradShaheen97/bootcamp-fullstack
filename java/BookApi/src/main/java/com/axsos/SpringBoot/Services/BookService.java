package com.axsos.SpringBoot.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.SpringBoot.Models.Books;
import com.axsos.SpringBoot.repositeries.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepo;

	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	public List<Books> allBooks() {
		return bookRepo.findAll();
	}

	public Books findBook(Long id) {
		return bookRepo.findById(id).orElse(null);
	}

	public Books createBook(String title, String descreption, String languge, Integer pages) {
		Books book = new Books(title, descreption, languge, pages);
		return bookRepo.save(book);
	}

	public Books updateBook(long id, String title, String descreption, String languge, Integer pages) {
		Optional<Books> optBook = bookRepo.findById(id);
		if (optBook.isPresent()) {
			Books book = optBook.get();
			book.setTitle(title);
			book.setDescreption(descreption);
			book.setLanguage(languge);
			book.setPages(pages);
			bookRepo.save(book);
			return book;
		}
		return null;
	}

	public void deleteBook(long id) {
		Optional<Books> optBook = bookRepo.findById(id);
		if (optBook.isPresent()) {
			Books book = optBook.get();
			bookRepo.delete(book);
		}
	}
}