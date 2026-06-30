# Omikuji Assignment

## Description

This project is a Spring Boot web application that generates a personalized **Omikuji Fortune**. Users fill out a form, the submitted data is stored in the session, and a fortune is displayed on a separate page.

## Features

* JSP pages
* JSTL for dynamic content
* Session to store user input
* Static CSS styling
* Spring MVC Controller
* Form submission using POST

## Routes

| Route              | Method | Description                                       |
| ------------------ | ------ | ------------------------------------------------- |
| `/omikuji`         | GET    | Displays the Omikuji form                         |
| `/omikuji/process` | POST   | Processes the form and stores data in the session |
| `/omikuji/show`    | GET    | Displays the generated fortune                    |

## Technologies Used

* Java
* Spring Boot
* Spring MVC
* JSP
* JSTL
* HTML
* CSS

## Project Structure

```text
src
├── main
│   ├── java
│   │   └── controllers
│   │       └── OmikujiController.java
│   ├── resources
│   │   ├── static
│   │   │   └── css
│   │   │       └── style.css
│   │   └── application.properties
│   └── webapp
│       └── WEB-INF
│           ├── omikuji.jsp
│           └── show.jsp
```

## How to Run

1. Import the project into your IDE.
2. Make sure Maven dependencies are installed.
3. Run the Spring Boot application.
4. Open your browser and visit:

```
http://localhost:8080/omikuji
```

5. Complete the form and click **Send**.
6. View your personalized fortune on the next page.

## Author

**Murad Shaheen**
