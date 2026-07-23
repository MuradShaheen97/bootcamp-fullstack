package com.axsos.exam.services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.axsos.exam.models.LoginUser;
import com.axsos.exam.models.User;
import com.axsos.exam.repositories.UserRepository;

/**
 * USER SERVICE
 * Contains registration, login, password encryption, and user lookup logic.
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // Constructor injection gives the service its repository dependency.
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /** Validate registration data, encrypt password, then save the user. */
    public User register(User newUser, BindingResult result) {

        // Normalize email so Test@Email.com and test@email.com are treated alike.
        if (newUser.getEmail() != null) {
            newUser.setEmail(newUser.getEmail().trim().toLowerCase());
        }

        if (newUser.getFirstName() != null) {
            newUser.setFirstName(newUser.getFirstName().trim());
        }

        // Email must be unique.
        if (newUser.getEmail() != null && userRepository.findByEmail(newUser.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "This email is already registered");
        }

        // Username must also be unique.
        if (newUser.getFirstName() != null && userRepository.findByEmail(newUser.getFirstName()).isPresent()) {
            result.rejectValue("username", "Unique", "This username is already taken");
        }

        // Password and confirm password must be equal.
        if (newUser.getPassword() != null && !newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "Password and confirm password must match");
        }

        // Do not save when any validation error exists.
        if (result.hasErrors()) {
            return null;
        }

        // Never save a plain-text password. BCrypt creates a secure hash.
        String hashedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(hashedPassword);

        return userRepository.save(newUser);
    }

    /** Check email and password, then return the logged-in user. */
    public User login(LoginUser loginUser, BindingResult result) {

        if (loginUser.getEmail() != null) {
            loginUser.setEmail(loginUser.getEmail().trim().toLowerCase());
        }

        Optional<User> possibleUser = userRepository.findByEmail(loginUser.getEmail());

        if (possibleUser.isEmpty()) {
            result.rejectValue("email", "NotFound", "No account was found with this email");
            return null;
        }

        User user = possibleUser.get();

        // matches(raw password, encrypted password)
        if (!passwordEncoder.matches(loginUser.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Incorrect password");
            return null;
        }

        return user;
    }

    public User findUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
