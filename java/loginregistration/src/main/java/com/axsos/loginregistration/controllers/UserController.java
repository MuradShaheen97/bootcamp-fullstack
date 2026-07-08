package com.axsos.loginregistration.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.axsos.loginregistration.models.LoginUser;
import com.axsos.loginregistration.models.User;
import com.axsos.loginregistration.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());

		return "index";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		User registeredUser = userService.register(newUser, result);

		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index";
		}

		session.setAttribute("userId", registeredUser.getId());

		return "redirect:/welcome";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		User user = userService.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index";
		}

		session.setAttribute("userId", user.getId());

		return "redirect:/welcome";
	}

	@GetMapping("/welcome")
	public String welcome(HttpSession session, Model model) {

		Long userId = (Long) session.getAttribute("userId");

		if (userId == null) {
			return "redirect:/";
		}

		User user = userService.findUserById(userId);

		if (user == null) {
			return "redirect:/logout";
		}

		model.addAttribute("user", user);

		return "welcome";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}