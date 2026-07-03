# Books MVC API Project

A Spring Boot MVC REST API built to manage a database repository of books. This project implements full CRUD (Create, Read, Update, Delete) database operations using Spring Data JPA, Hibernate, and an H2/MySQL database engine.

---

## 🛠 Project Architecture & Package Structure

The system uses standard enterprise-grade decoupling separation layers:

```text
src/main/java/com/axsos/SpringBoot/
│
├── Models/
│   └── Books.java                 # JPA Database Entity with Validations
│
├── repositeries/
│   └── BookRepository.java        # Spring Data CrudRepository Interface
│
├── Services/
│   └── BookService.java           # Internal Business Logic Layer
│
└── Controllers/
    ├── BooksApi.java              # REST API Controller for Postman Data
    └── BookController.java        # Base Controller for future UI Templates
```

---

## 🏗 Setup & Installation

1. **Prerequisites:** Ensure you have **Java JDK 17+** and **Maven** installed on your system.
2. **Clone/Open the Project:** Import the folder into your favorite IDE (Eclipse, IntelliJ IDEA, or Spring Tool Suite).
3. **Database Configuration:** Verify your database credentials in `src/main/resources/application.properties`.
4. **Run Application:** Start the application context by executing the main file containing the `@SpringBootApplication` annotation, or run this terminal command:
   ```bash
   mvn spring-boot:run
   ```
5. **Port Configuration:** By default, the embedded server launches locally at `http://localhost:8080`.

---

## 🧪 Testing Endpoints with Postman

Since this API utilizes `@RequestParam` bindings, all payloads sent through Postman must be submitted using the **`x-www-form-urlencoded`** body type.

### 1. Create a New Book
* **HTTP Method:** `POST`
* **URL:** `http://localhost:8080/api/books`
* **Body Tab:** Select `x-www-form-urlencoded`
* **Key-Value Form Data:**

  | Key | Example Value | Validation Constraints |
  | :--- | :--- | :--- |
  | `title` | `The Hobbit` | Min 2, Max 15 characters |
  | `description` | `An epic high-fantasy novel.` | Min 2, Max 255 characters |
  | `language` | `English` | Min 2, Max 15 characters |
  | `pages` | `310` | Minimum value of 8 |

---

### 2. Update an Existing Book
Modifies an existing data record safely without creating accidental duplicates.
* **HTTP Method:** `PUT`
* **URL:** `http://localhost:8080/api/books/{id}` (e.g., `http://localhost:8080/api/books/1`)
* **Body Tab:** Select `x-www-form-urlencoded`
* **Key-Value Form Data:**

  | Key | Example Updated Value |
  | :--- | :--- |
  | `title` | `The Hobbit 2` |
  | `description` | `Revised description text.` |
  | `language` | `Spanish` |
  | `pages` | `350` |

---

### 3. Delete a Book
Permanently removes a book row instance from the tracking repository by identity sequence.
* **HTTP Method:** `DELETE`
* **URL:** `http://localhost:8080/api/books/{id}` (e.g., `http://localhost:8080/api/books/1`)
* **Body:** None (Leave completely empty)

---

## ⚠️ Database Validation Constraints

The project model implements strict validation safety barriers. Requests violating these conditions will throw a `400 Bad Request` execution rejection:
* **Title & Language:** String size must range strictly between **2 and 15 characters**.
* **Description:** String size must range between **2 and 255 characters**.
* **Pages:** Integer cannot fall below a count of **8 total pages**.
