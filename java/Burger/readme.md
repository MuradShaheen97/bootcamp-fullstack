# 🍔 Burger Tracker Application

A full-stack Spring Boot web application designed to track, rate, and review burgers from various restaurants. Built using **Spring Boot (v4.1.0)**, **Spring Data JPA**, and **MySQL**, this application implements full CRUD operations with robust data validation.

---

## 🚀 Features

* **Track Your Favorites:** Log burger names, restaurant locations, and personal notes.
* **Rating System:** Rate burgers using a strict 1 to 5-star validation constraint.
* **Automated Timestamps:** Uses JPA lifecycle hooks (`@PrePersist` and `@PreUpdate`) to track when records are created or modified.
* **Duplicate Prevention:** Custom repository logic to check if a burger name already exists before adding it.

---

## 🛠️ Tech Stack & Architecture

This project follows the standard **MVC (Model-View-Controller)** pattern:

* **Backend Framework:** Spring Boot (Java 25)
* **Database ORM:** Hibernate / Spring Data JPA
* **Database:** MySQL (Local instance)
* **Validation:** Jakarta Bean Validation (`@NotNull`, `@Size`, `@Min`, `@Max`)

### Project Structure

The application uses strict package nesting to ensure auto-configuration and component scanning function seamlessly:

```text
src/main/java/com/axsos/SpringBoot/Burger/
├── BurgerApplication.java      # Main application entry point
├── controllers/
│   └── BurgerController.java   # Routing & Request handling
├── Services/
│   └── BurgerService.java      # Core business logic layer
├── Repositories/
│   └── BurgerRepositorie.java  # Spring Data JPA Database interface
└── Models/
    └── Burgers.java            # JPA Database Entity

![](C:\Users\zzeta\OneDrive\Pictures\Screenshots\Screenshot%202026-07-06%20172411.png)

![](C:\Users\zzeta\OneDrive\Pictures\Screenshots\Screenshot%202026-07-06%20172422.png)