# Counter Assignment

## Overview

This Spring Boot application demonstrates how to use **HTTP Sessions** to keep track of the number of times a user visits a page.

## Features

* Counter starts at **0**
* Visiting the home page (`/`) increments the counter by **1**
* View the current count at `/counter`
* Bonus: Increment the counter by **2** at `/counter2`
* Bonus: Reset the counter to **0**

## Technologies

* Java
* Spring Boot
* Spring MVC
* JSP
* HTTP Session

## Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.axsos.counter
│   │       ├── CounterApplication.java
│   │       └── controllers
│   │           └── CounterController.java
│   ├── resources
│   │   └── application.properties
│   └── webapp
│       └── WEB-INF
│           ├── index.jsp
│           ├── counter.jsp
│           └── counter2.jsp
```

## Routes

| Route       | Description                        |
| ----------- | ---------------------------------- |
| `/`         | Increments the counter by 1        |
| `/counter`  | Displays the current counter value |
| `/counter2` | Increments the counter by 2        |
| `/reset`    | Resets the counter to 0            |

## How to Run

1. Open the project in **Spring Tool Suite** or **IntelliJ IDEA**.
2. Run the `CounterApplication` class.
3. Open your browser and visit:

```
http://localhost:8080/
```

## Screenshots

Add screenshots of:

* Home Page
* Counter Page
* Counter +2 Page
* Reset Counter

Example:

```
README Images/
├── home.png
├── counter.png
├── counter2.png
└── reset.png
```

## Author

**Murad Shaheen**
