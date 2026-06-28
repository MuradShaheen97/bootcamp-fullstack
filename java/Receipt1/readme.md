# Receipt

## Description

A simple Spring Boot MVC application that displays a purchase receipt using JSP and JSTL. The controller sends purchase information to the view through the `Model`, and the data is rendered dynamically on the page.

---

## Technologies

- Java
- Spring Boot
- Spring MVC
- JSP
- JSTL
- Maven

---

## Features

- Display customer name
- Display purchased item
- Display item price
- Display item description
- Display vendor information
- Render dynamic data using JSP and JSTL

---

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── axsos
│   │           └── receipt
│   │               ├── ReceiptApplication.java
│   │               └── controllers
│   │                   └── ReceiptController.java
│   ├── resources
│   │   └── application.properties
│   └── webapp
│       └── WEB-INF
│           └── index.jsp
```

---

## How to Run

1. Clone the repository.
2. Open the project in your IDE.
3. Run the Spring Boot application.
4. Visit:

```
http://localhost:8080/
```

---

## Sample Output

```
Receipt

Customer Name: Murad Shaheen
Item Name: Gaming Mouse
Price: $25.99
Description: Wireless mouse with RGB lights.
Vendor: Tech Store
```

---

## Author

Murad Shaheen