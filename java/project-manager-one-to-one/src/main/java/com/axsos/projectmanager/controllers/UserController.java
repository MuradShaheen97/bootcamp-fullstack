package com.axsos.projectmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.projectmanager.models.LoginUser;
import com.axsos.projectmanager.models.User;
import com.axsos.projectmanager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
     * GET /
     * Shows registration and login forms.
     */
    @GetMapping("/")
    public String index(
            Model model,
            HttpSession session) {

        // Logged-in users go directly to the dashboard.
        if (session.getAttribute("userId") != null) {
            return "redirect:/dashboard";
        }

        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());

        return "login";
    }

    /*
     * POST /register
     * Receives and validates the registration form.
     */
    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute("newUser") User newUser,
            BindingResult result,
            Model model,
            HttpSession session) {

        User registeredUser = userService.register(newUser, result);

        if (result.hasErrors()) {
            // The login form must still exist when registration fails.
            model.addAttribute("newLogin", new LoginUser());
            return "login";
        }

        // Save only the user id in session, not the full user object.
        session.setAttribute("userId", registeredUser.getId());

        return "redirect:/dashboard";
    }

    /*
     * POST /login
     * Checks email and password.
     */
    @PostMapping("/login")
    public String login(
            @Valid @ModelAttribute("newLogin") LoginUser newLogin,
            BindingResult result,
            Model model,
            HttpSession session) {

        User loggedUser = userService.login(newLogin, result);

        if (result.hasErrors()) {
            // The registration form must still exist when login fails.
            model.addAttribute("newUser", new User());
            return "login";
        }

        session.setAttribute("userId", loggedUser.getId());

        return "redirect:/dashboard";
    }

    /*
     * GET /logout
     * Removes all session data.
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
