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

	public Books createBook(Books book) {
		return bookRepo.save(book);
	}

	public Books updateBook(long id, Books book) {
		Optional<Books> optBook = bookRepo.findById(id);
		if (optBook.isPresent()) {
			Books upbook = optBook.get();

			// Map the updated form values onto the existing database record
			upbook.setTitle(book.getTitle());
			upbook.setLanguage(book.getLanguage());
			upbook.setPages(book.getPages());

			// Handle your specific spelling variant ("description")
			upbook.setDescription(book.getDescription());

			return bookRepo.save(upbook);
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