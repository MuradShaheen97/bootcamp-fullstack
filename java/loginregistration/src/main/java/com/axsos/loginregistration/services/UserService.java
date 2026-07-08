package com.axsos.loginregistration.services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.axsos.loginregistration.models.LoginUser;
import com.axsos.loginregistration.models.User;
import com.axsos.loginregistration.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	private final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User register(User newUser, BindingResult result) {

		Optional<User> potentialUser = userRepository.findByEmail(newUser.getEmail());

		if (potentialUser.isPresent()) {
			result.rejectValue("email", "Unique", "This email is already taken");
		}

		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Confirm Password must match Password");
		}

		if (result.hasErrors()) {
			return null;
		}

		String hashedPassword = bcrypt.encode(newUser.getPassword());
		newUser.setPassword(hashedPassword);

		return userRepository.save(newUser);
	}

	public User login(LoginUser newLoginObject, BindingResult result) {

		Optional<User> potentialUser = userRepository.findByEmail(newLoginObject.getEmail());

		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "Missing", "Invalid email or password");
			return null;
		}

		User user = potentialUser.get();

		if (!bcrypt.matches(newLoginObject.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid email or password");
		}

		if (result.hasErrors()) {
			return null;
		}

		return user;
	}
}