# Burger Tracker

Spring Boot MVC application to track burger experiences.

## Features

- Display all burgers
- Add a new burger
- Validate form inputs
- Save data to MySQL

## Technologies

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- MySQL
- JSP
- JSTL
- Maven

## Routes

| Method | Route | Description |
|---|---|---|
| GET | `/` | Display all burgers and form |
| POST | `/burgers` | Create a new burger |

## Database

```sql
CREATE SCHEMA burger_tracker_schema;