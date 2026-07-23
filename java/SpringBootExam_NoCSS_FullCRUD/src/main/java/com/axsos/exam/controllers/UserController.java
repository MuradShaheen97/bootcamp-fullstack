package com.axsos.exam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.exam.models.LoginUser;
import com.axsos.exam.models.User;
import com.axsos.exam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

/** Handles registration, login, profile dashboard, and logout routes. */
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Display both registration and login forms.
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            return "redirect:/dashboard";
        }

        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login";
    }

    // Process the registration form.
    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute("newUser") User newUser,
            BindingResult result,
            Model model,
            HttpSession session) {

        User registeredUser = userService.register(newUser, result);

        if (result.hasErrors()) {
            // The page contains two forms, so the login object must be added again.
            model.addAttribute("newLogin", new LoginUser());
            return "login";
        }

        // Save only the user id in session, not the entire user object.
        session.setAttribute("userId", registeredUser.getId());
        return "redirect:/dashboard";
    }

    // Process the login form.
    @PostMapping("/login")
    public String login(
            @Valid @ModelAttribute("newLogin") LoginUser newLogin,
            BindingResult result,
            Model model,
            HttpSession session) {

        User loggedUser = userService.login(newLogin, result);

        if (result.hasErrors()) {
            // The page contains two forms, so the registration object must be added again.
            model.addAttribute("newUser", new User());
            return "login";
        }

        session.setAttribute("userId", loggedUser.getId());
        return "redirect:/dashboard";
    }

   

    // End the session and send the user back to login.
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
