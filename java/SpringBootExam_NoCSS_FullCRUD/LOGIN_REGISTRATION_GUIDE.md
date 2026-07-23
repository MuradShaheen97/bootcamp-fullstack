# Login and Registration Guide

## What was added

- Complete `User` entity with first name, last name, username, email, phone, date of birth, gender, address, city, country, occupation, bio, password, confirm password, terms checkbox, created date, and updated date.
- `LoginUser` DTO for login form validation.
- `UserRepository` with email and username lookup.
- `UserService` with registration, duplicate checking, password matching, and BCrypt password encryption.
- `UserController` with `/`, `/register`, `/login`, `/dashboard`, and `/logout`.
- Complete `login.jsp` and `dashboard.jsp` pages.

## Before running

1. Open MySQL Workbench.
2. Run `database.sql`.
3. Check `application.properties` and update the MySQL username/password when needed.
4. In Eclipse/STS: right-click project → Maven → Update Project.
5. Run the project as Spring Boot App.
6. Open `http://localhost:8080/`.

## Important exam flow

1. GET `/` creates empty `newUser` and `newLogin` objects.
2. POST `/register` validates the user.
3. Service checks duplicate email/username and matching passwords.
4. Service encrypts the password using BCrypt.
5. Controller stores `userId` in session.
6. GET `/dashboard` checks the session and loads the user.
7. GET `/logout` invalidates the session.
