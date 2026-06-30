# Ninja Gold Game

## Description
Ninja Gold is a Spring Boot web application where the player collects gold by visiting different locations. Each location rewards or removes a random amount of gold. All activities are saved with a timestamp using HTTP Session.

## Features
- Start with 0 gold
- Farm earns **10–20** gold
- Cave earns **5–10** gold
- House earns **2–5** gold
- Quest earns or loses **0–50** gold
- Spa loses **5–20** gold (Bonus)
- Activity log with timestamps
- Reset button to restart the game (Bonus)
- Debtors' Prison page when gold reaches **-100** or less (Bonus)

## Technologies Used
- Java
- Spring Boot
- Spring MVC
- JSP
- HTML
- CSS
- HTTP Session

## Routes

| Route | Method | Description |
|--------|--------|-------------|
| `/` | GET | Display the Ninja Gold game |
| `/process` | POST | Process player action |
| `/` | GET | Display Debtors' Prison if gold ≤ -100 |

## Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.axsos.NinjaGold
│   │       ├── NinjaGoldApplication.java
│   │       └── NinjaGoldController.java
│   ├── resources
│   │   ├── static
│   │   │   └── css
│   │   │       └── style.css
│   │   └── application.properties
│   └── webapp
│       └── WEB-INF
│           ├── index.jsp
│           └── prison.jsp
```

## How to Run

1. Import the project into Eclipse or IntelliJ.
2. Update Maven dependencies.
3. Run the Spring Boot application.
4. Open your browser:

```
http://localhost:8080/
```

5. Visit different places to earn or lose gold.
6. Check the activity log for all actions.
7. Click **Reset Game** to start over.

## Author

**Murad Shaheen**