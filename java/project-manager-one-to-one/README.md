# Project Manager — One-to-One

A clean Spring Boot study project containing:

- Login
- Registration
- BCrypt password hashing
- Session
- Full Project CRUD
- One-to-One relationship between `User` and `Project`
- JSP views
- MySQL
- Only four application packages:
  - `controllers`
  - `models`
  - `repositories`
  - `services`

There is no team and no Join Team button. Each user can own only one project.

---

## Project Tree

```text
project-manager-one-to-one/
├── pom.xml
├── database.sql
├── README.md
└── src/
    └── main/
        ├── java/com/axsos/projectmanager/
        │   ├── ProjectManagerApplication.java
        │   ├── controllers/
        │   │   ├── ProjectController.java
        │   │   └── UserController.java
        │   ├── models/
        │   │   ├── LoginUser.java
        │   │   ├── Project.java
        │   │   └── User.java
        │   ├── repositories/
        │   │   ├── ProjectRepository.java
        │   │   └── UserRepository.java
        │   └── services/
        │       ├── ProjectService.java
        │       └── UserService.java
        ├── resources/
        │   └── application.properties
        └── webapp/WEB-INF/
            ├── dashboard.jsp
            ├── edit.jsp
            ├── login.jsp
            ├── new.jsp
            └── show.jsp
```

---

## Before Running

### 1. Create the database

Open MySQL Workbench and run:

```sql
CREATE DATABASE IF NOT EXISTS project_manager_db;
```

You can also run the included `database.sql`.

You do not need to create the tables. Hibernate creates them from the Java models.

### 2. Set your MySQL password

Open:

```text
src/main/resources/application.properties
```

Replace:

```properties
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

with your real MySQL password.

Example:

```properties
spring.datasource.password=root
```

If your MySQL password is empty:

```properties
spring.datasource.password=
```

---

## Import Into Eclipse STS

1. Unzip the downloaded file.
2. Open Eclipse STS.
3. Click `File`.
4. Click `Import`.
5. Choose `Maven` → `Existing Maven Projects`.
6. Click `Next`.
7. Select the unzipped `project-manager-one-to-one` folder.
8. Make sure `pom.xml` is selected.
9. Click `Finish`.
10. Wait for Maven to download dependencies.

If the project has red lines:

1. Right-click the project.
2. Choose `Maven` → `Update Project`.
3. Check `Force Update`.
4. Click `OK`.

---

## Run

1. Open `ProjectManagerApplication.java`.
2. Right-click.
3. Choose `Run As` → `Spring Boot App`.
4. Open:

```text
http://localhost:8080
```

---

## One-to-One Explanation

The foreign key is stored in the `projects` table:

```java
@OneToOne
@JoinColumn(name = "owner_id", unique = true)
private User owner;
```

`unique = true` prevents the same user from owning more than one project.

The `User` model points back to its project:

```java
@OneToOne(mappedBy = "owner")
private Project project;
```

`mappedBy = "owner"` means the `Project.owner` field owns the relationship.

---

## CRUD Routes

| Operation | Method | Route |
|---|---|---|
| Create form | GET | `/projects/new` |
| Create project | POST | `/projects` |
| Read project | GET | `/projects/{id}` |
| Edit form | GET | `/projects/{id}/edit` |
| Update project | POST | `/projects/{id}/update` |
| Delete project | POST | `/projects/{id}/delete` |

---

## Login and Registration Routes

| Operation | Method | Route |
|---|---|---|
| Login/Register page | GET | `/` |
| Register | POST | `/register` |
| Login | POST | `/login` |
| Logout | GET | `/logout` |

---

## Exam Memory

Follow this order:

1. Model
2. Repository
3. Service
4. Controller
5. JSP
6. `application.properties`
7. Database
8. Run and test

CRUD order:

```text
CREATE → READ → UPDATE → DELETE
```

Spring MVC request flow:

```text
Browser → Controller → Service → Repository → MySQL
Browser ← JSP ← Controller
```
