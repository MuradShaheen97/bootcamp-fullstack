package com.axsos.SpringBoot.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axsos.SpringBoot.Models.Books;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {

}