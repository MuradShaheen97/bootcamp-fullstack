package com.axsos.exam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.exam.models.Blog;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Long> {

    /*
     * CrudRepository returns Iterable by default.
     *
     * Defining findAll() as List makes it easier to use
     * inside the service and controller.
     */
    List<Blog> findAll();
}