package com.axsos.exam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.exam.models.Blog;
import com.axsos.exam.repositories.BlogRepository;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    // =========================================================
    // READ ALL
    // =========================================================

    public Iterable<Blog> allBlogs() {
        return blogRepository.findAll();
    }

    // =========================================================
    // READ ONE
    // =========================================================

    public Blog findBlog(Long id) {

        Optional<Blog> optionalBlog = blogRepository.findById(id);

        if (optionalBlog.isPresent()) {
            return optionalBlog.get();
        }

        return null;
    }

    // =========================================================
    // CREATE
    // =========================================================

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    // =========================================================
    // UPDATE
    // =========================================================

    public Blog updateBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    // =========================================================
    // DELETE
    // =========================================================

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}