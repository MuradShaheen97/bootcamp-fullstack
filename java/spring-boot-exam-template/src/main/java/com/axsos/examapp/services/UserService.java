package com.axsos.examapp.services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.axsos.examapp.models.LoginUser;
import com.axsos.examapp.models.User;
import com.axsos.examapp.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

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

        if (existingUser.isPresent()) {
            result.rejectValue(
                    "email",
                    "Duplicate",
                    "This email is already registered."
            );
        }

        if (newUser.getPassword() != null
                && !newUser.getPassword().equals(newUser.getConfirm())) {

            result.rejectValue(
                    "confirm",
                    "Matches",
                    "Passwords must match."
            );
        }

        if (result.hasErrors()) {
            return null;
        }

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

    public User findUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
