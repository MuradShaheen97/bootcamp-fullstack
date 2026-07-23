package com.axsos.projectmanager.services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.axsos.projectmanager.models.LoginUser;
import com.axsos.projectmanager.models.User;
import com.axsos.projectmanager.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    /*
     * Constructor Injection:
     * Spring gives this service the repository and password encoder.
     */
    public UserService(
            UserRepository userRepository,
            BCryptPasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // =========================
    // REGISTER
    // =========================
    public User register(User newUser, BindingResult result) {

        Optional<User> existingUser =
                userRepository.findByEmail(newUser.getEmail());

        // Email must be unique.
        if (existingUser.isPresent()) {
            result.rejectValue(
                    "email",
                    "Duplicate",
                    "This email is already registered."
            );
        }

        // Password and confirm password must match.
        if (newUser.getPassword() != null
                && !newUser.getPassword().equals(newUser.getConfirm())) {

            result.rejectValue(
                    "confirm",
                    "Matches",
                    "Passwords must match."
            );
        }

        // Stop if validation or custom errors exist.
        if (result.hasErrors()) {
            return null;
        }

        // Never save the plain password.
        String hashedPassword =
                passwordEncoder.encode(newUser.getPassword());

        newUser.setPassword(hashedPassword);

        return userRepository.save(newUser);
    }

    // =========================
    // LOGIN
    // =========================
    public User login(LoginUser loginUser, BindingResult result) {

        Optional<User> optionalUser =
                userRepository.findByEmail(loginUser.getEmail());

        if (optionalUser.isEmpty()) {
            result.rejectValue(
                    "email",
                    "NotFound",
                    "Email not found."
            );
            return null;
        }

        User user = optionalUser.get();

        // Compare the typed password with the hashed database password.
        if (!passwordEncoder.matches(
                loginUser.getPassword(),
                user.getPassword())) {

            result.rejectValue(
                    "password",
                    "Matches",
                    "Invalid password."
            );
            return null;
        }

        return user;
    }

    // READ ONE USER
    public User findUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
