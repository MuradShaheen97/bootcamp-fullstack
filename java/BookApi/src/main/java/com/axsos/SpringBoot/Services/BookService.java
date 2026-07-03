package com.axsos.SpringBoot.Services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.SpringBoot.Models.Books;
import com.axsos.SpringBoot.repositeries.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepo;
	public BookService(BookRepository bookRepo) {
		this.bookRepo=bookRepo;
	}
	
	public void createBook(String title , String descreption , String languge , Integer pages ) {
		Books book = new Books (title, descreption , languge, pages  );
		bookRepo.save(book);
	} 
	public void updateBook(long id ,String title , String descreption , String languge , Integer pages ) {
		 Optional<Books> optBook = bookRepo.findById(id);
		 if(optBook.isPresent()) {
			 Books book=optBook.get();
			 book.setDescreption(descreption);
			 book.setLanguage(languge);
			 book.setPages(pages);
			 bookRepo.save(book);
		 }

	}
	
	public void deleteBook(long id) {
		 Optional<Books> optBook = bookRepo.findById(id);
		 if(optBook.isPresent()) {
			 Books book=optBook.get();
			 bookRepo.delete(book);
		 }

	}

}
