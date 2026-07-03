package com.axsos.BooksAPI.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.axsos.BooksAPI.models.Books;

@Repository
public interface BooksRepository extends CrudRepository<Books, Long> {
    List<Books> findAll();
}