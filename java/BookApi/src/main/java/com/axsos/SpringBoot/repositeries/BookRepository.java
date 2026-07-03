package com.axsos.SpringBoot.repositeries; 

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.axsos.SpringBoot.Models.Books; 

@Repository
public interface BookRepository extends CrudRepository<Books, Long> {
	
}

