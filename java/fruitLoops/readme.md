# Fruit Loops Assignment

## Description
This project is a Spring Boot MVC web application that displays a Fruit Store page.

The fruit data is created inside the controller using an `ArrayList` of `Item` objects, then passed to the JSP page using `Model`.

The JSP page uses JSTL `c:forEach` to loop through the fruits and display them dynamically in a table.

## Technologies Used
- Java
- Spring Boot
- Spring MVC
- JSP
- JSTL
- Maven
- CSS

## Features
- Create fruits using an `Item` model class.
- Store fruits in an `ArrayList`.
- Pass data from Controller to JSP using `Model`.
- Display data dynamically using `c:forEach`.
- Styled Fruit Store table.
- Ninja Bonus: fruits starting with `G` are shown in orange.

## Project Structure
```text
src/main/java/com/axsos/fruitLoops
├── FruitLoopsApplication.java
├── Controllers
│   └── ItemController.java
└── models
    └── Item.java

src/main/webapp/WEB-INF
└── index.jsp