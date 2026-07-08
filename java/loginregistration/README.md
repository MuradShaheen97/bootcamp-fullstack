# Login and Registration

## Description

This is a Spring Boot MVC project for user registration, login, session, and logout.

## Features

- Register new user
- Validate username, email, password, and confirm password
- Check if email already exists
- Hash password using BCrypt
- Login with email and password
- Save user ID in session
- Protect welcome page from users who are not logged in
- Logout and clear session

## Routes

| Method | Route | Description |
|---|---|---|
| GET | / | Display login and registration page |
| POST | /register | Register new user |
| POST | /login | Login user |
| GET | /welcome | Dashboard page |
| GET | /logout | Logout user |

## Validations

### Registration

- Username is required
- Username must be at least 3 characters
- Username must contain letters only
- Email is required
- Email must be valid
- Email must be unique
- Password is required
- Password must be at least 8 characters
- Confirm password must match password

### Login

- Email is required
- Email must be valid
- Password is required
- Email must exist in database
- Password must match saved password

## Database

Create this schema in MySQL:

```sql
CREATE DATABASE loginregistration_schema;