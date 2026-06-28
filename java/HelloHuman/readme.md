# Hello Human

## Description
A simple Spring Boot application that greets visitors using **Path Variables**.

If no name is provided, the application displays:

```
Hello Human
```

If a first name is provided:

```
Hello Murad
```

If both first and last names are provided:

```
Hello Murad Shaheen
```

---

## Technologies Used

- Java
- Spring Boot
- Maven

---

## Routes

| URL | Output |
|------|--------|
| `/` | Hello Human |
| `/Murad` | Hello Murad |
| `/Murad/Shaheen` | Hello Murad Shaheen |
| `/Murad/times/3` *(Bonus)* | Hello Murad (3 times) |

---

## Features

- Default greeting
- Greeting with first name
- Greeting with first and last name
- Bonus: Repeat greeting multiple times using a path variable

---

## Project Structure

```
src
└── main
    └── java
        └── com
            └── axsos
                └── HelloHuman
                    ├── HumanController.java
                    └── HelloHumanApplication.java
```

---

## How to Run

1. Clone the repository.
2. Open the project in Eclipse or IntelliJ.
3. Run `HelloHumanApplication`.
4. Open your browser and visit:

```
http://localhost:8080/
```

---

## Author

Murad Shaheen