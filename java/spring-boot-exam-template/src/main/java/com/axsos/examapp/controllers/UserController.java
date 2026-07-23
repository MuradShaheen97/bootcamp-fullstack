package com.axsos.examapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.examapp.models.LoginUser;
import com.axsos.examapp.models.User;
import com.axsos.examapp.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // SHOW LOGIN + REGISTER
    @GetMapping("/")
    public String index(Model model, HttpSession session) {

        if (session.getAttribute("userId") != null) {
            return "redirect:/dashboard";
        }

        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());

        return "login";
    }

    // REGISTER
    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute("newUser") User newUser,
            BindingResult result,
            Model model,
            HttpSession session) {

        User registeredUser = userService.register(newUser, result);

        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "login";
        }

        session.setAttribute("userId", registeredUser.getId());

        return "redirect:/dashboard";
    }

    // LOGIN
    @PostMapping("/login")
    public String login(
            @Valid @ModelAttribute("newLogin") LoginUser newLogin,
            BindingResult result,
            Model model,
            HttpSession session) {

        User loggedUser = userService.login(newLogin, result);

        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login";
        }

        session.setAttribute("userId", loggedUser.getId());

        return "redirect:/dashboard";
    }

    // LOGOUT
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
