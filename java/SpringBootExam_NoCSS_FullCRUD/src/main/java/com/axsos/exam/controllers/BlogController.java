package com.axsos.exam.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.exam.models.Blog;
import com.axsos.exam.models.User;
import com.axsos.exam.services.BlogService;
import com.axsos.exam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BlogController {

    private final BlogService blogService;
    private final UserService userService;

    public BlogController(BlogService blogService, UserService userService) {
        this.blogService = blogService;
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User loggedUser = getLoggedUser(session);

        if (loggedUser == null) {
            return "redirect:/";
        }

        List<Blog> allBlogs = (List<Blog>) blogService.allBlogs();
        List<Blog> myBlogs = allBlogs.stream()
                .filter(blog -> blog.getOwner() != null)
                .filter(blog -> blog.getOwner().getId().equals(loggedUser.getId()))
                .toList();

        model.addAttribute("currentUser", loggedUser);
        model.addAttribute("allBlogs", allBlogs);
        model.addAttribute("myBlogs", myBlogs);

        return "dashboard";
    }

    @GetMapping("/blogs/new")
    public String newBlog(HttpSession session, Model model) {
        if (getLoggedUser(session) == null) {
            return "redirect:/";
        }

        model.addAttribute("newBlog", new Blog());
        return "new";
    }

    @PostMapping("/blogs")
    public String createBlog(
            @Valid @ModelAttribute("newBlog") Blog newBlog,
            BindingResult result,
            HttpSession session) {

        User loggedUser = getLoggedUser(session);

        if (loggedUser == null) {
            return "redirect:/";
        }

        if (result.hasErrors()) {
            return "new";
        }

        newBlog.setOwner(loggedUser);
        blogService.createBlog(newBlog);

        return "redirect:/dashboard";
    }

    @GetMapping("/blogs/{id}")
    public String showBlog(@PathVariable("id") Long id, HttpSession session, Model model) {
        if (getLoggedUser(session) == null) {
            return "redirect:/";
        }

        Blog blog = blogService.findBlog(id);

        if (blog == null) {
            return "redirect:/dashboard";
        }

        model.addAttribute("blog", blog);
        return "show";
    }

    @GetMapping("/blogs/{id}/edit")
    public String editBlog(@PathVariable("id") Long id, HttpSession session, Model model) {
        User loggedUser = getLoggedUser(session);

        if (loggedUser == null) {
            return "redirect:/";
        }

        Blog blog = blogService.findBlog(id);

        if (blog == null || !isOwner(blog, loggedUser)) {
            return "redirect:/dashboard";
        }

        model.addAttribute("editBlog", blog);
        return "edit";
    }

    @PostMapping("/blogs/{id}/update")
    public String updateBlog(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute("editBlog") Blog formBlog,
            BindingResult result,
            HttpSession session) {

        User loggedUser = getLoggedUser(session);

        if (loggedUser == null) {
            return "redirect:/";
        }

        Blog existingBlog = blogService.findBlog(id);

        if (existingBlog == null || !isOwner(existingBlog, loggedUser)) {
            return "redirect:/dashboard";
        }

        if (result.hasErrors()) {
            return "edit";
        }

        existingBlog.setTitle(formBlog.getTitle());
        existingBlog.setAuthor(formBlog.getAuthor());
        existingBlog.setEventDate(formBlog.getEventDate());
        existingBlog.setCategory(formBlog.getCategory());
        existingBlog.setContent(formBlog.getContent());

        blogService.updateBlog(existingBlog);
        return "redirect:/blogs/" + id;
    }

    @PostMapping("/blogs/{id}/delete")
    public String deleteBlog(@PathVariable("id") Long id, HttpSession session) {
        User loggedUser = getLoggedUser(session);

        if (loggedUser == null) {
            return "redirect:/";
        }

        Blog blog = blogService.findBlog(id);

        if (blog != null && isOwner(blog, loggedUser)) {
            blogService.deleteBlog(id);
        }

        return "redirect:/dashboard";
    }

    private User getLoggedUser(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        return userId == null ? null : userService.findUser(userId);
    }

    private boolean isOwner(Blog blog, User user) {
        return blog != null
                && user != null
                && blog.getOwner() != null
                && blog.getOwner().getId().equals(user.getId());
    }
}
