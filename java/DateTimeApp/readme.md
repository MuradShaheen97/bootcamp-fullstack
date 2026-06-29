# Date & Time Display

## Overview

This Spring Boot project demonstrates how to display the current **date** and **time** using JSP, JSTL formatting tags, external CSS, and JavaScript.

## Features

* Dashboard with links to the Date and Time pages.
* Displays the current date using JSTL `<fmt:formatDate>`.
* Displays the current time using JSTL `<fmt:formatDate>`.
* External CSS for styling.
* External JavaScript alerts on page load.
* MVC architecture using Spring Boot.

## Technologies Used

* Java
* Spring Boot
* Spring MVC
* JSP
* JSTL
* HTML5
* CSS3
* JavaScript
* Maven

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com.axsos.datetime.controllers
│   │       └── HomeController.java
│   ├── resources
│   │   ├── static
│   │   │   ├── css
│   │   │   │   └── style.css
│   │   │   └── js
│   │   │       └── script.js
│   │   └── application.properties
│   └── webapp
│       └── WEB-INF
│           ├── index.jsp
│           ├── date.jsp
│           └── time.jsp
```

## Routes

| URL     | Description               |
| ------- | ------------------------- |
| `/`     | Dashboard page            |
| `/date` | Displays the current date |
| `/time` | Displays the current time |

## How to Run

1. Clone the repository.
2. Open the project in your IDE.
3. Install Maven dependencies.
4. Run the Spring Boot application.
5. Open your browser and visit:

```
http://localhost:8080/
```

## Learning Objectives

* Practice Spring Boot MVC.
* Pass data from Controller to JSP using the Model.
* Format dates and times using JSTL.
* Use external CSS and JavaScript files.
* Build a simple multi-page web application.

## Author

**Murad Shaheen**
