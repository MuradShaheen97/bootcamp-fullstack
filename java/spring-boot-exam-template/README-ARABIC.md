# قالب دراسة امتحان Java Spring Boot

هذا المشروع معمول للدراسة والتحضير قبل الامتحان، وفيه:

- Login
- Registration
- BCrypt
- Session
- CRUD كامل
- User + Item
- MySQL
- JSP
- فقط 4 Packages:
  - controllers
  - models
  - repositories
  - services

> استخدمه للتحضير والمراجعة وفق تعليمات الامتحان.

---

# أول شيء تعمله قبل الامتحان

## 1. جهّز قاعدة البيانات الآن

في MySQL Workbench شغّل:

```sql
CREATE DATABASE exam_app_db;
```

اسم قاعدة البيانات الجاهز في المشروع:

```text
exam_app_db
```

## 2. ضع باسورد MySQL

افتح:

```text
src/main/resources/application.properties
```

غيّر:

```properties
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

مثال:

```properties
spring.datasource.password=123456
```

إذا ما عندك باسورد:

```properties
spring.datasource.password=
```

---

# شو تحفظ للامتحان؟

احفظ ترتيب البناء:

```text
Model
↓
Repository
↓
Service
↓
Controller
↓
JSP
↓
Database + application.properties
```

واحفظ مسار الطلب:

```text
Browser → Controller → Service → Repository → MySQL
Browser ← JSP ← Controller
```

---

# ملفات Login و Registration التي تنقلها كما هي غالبًا

```text
models/User.java
models/LoginUser.java
repositories/UserRepository.java
services/UserService.java
controllers/UserController.java
login.jsp
```

ولا تنسى هذا داخل الملف الرئيسي:

```java
@Bean
BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```

---

# ملفات CRUD

```text
models/Item.java
repositories/ItemRepository.java
services/ItemService.java
controllers/ItemController.java
dashboard.jsp
new.jsp
edit.jsp
show.jsp
```

---

# كيف تغيّر Item إلى Game؟

اعمل Rename بهذا الترتيب:

```text
Item.java              → Game.java
ItemRepository.java    → GameRepository.java
ItemService.java       → GameService.java
ItemController.java    → GameController.java
```

داخل الكود:

```text
Item → Game
item → game
items → games
/items → /games
@Table(name = "items") → @Table(name = "games")
```

وفي JSP:

```text
modelAttribute="item" → modelAttribute="game"
${item.name}          → ${game.name}
${items}              → ${games}
```

---

# كيف تغيّر Item إلى Book؟

```text
Item → Book
item → book
items → books
/items → /books
```

الحقول مثلًا:

```java
private String title;
private String author;
private Double price;
```

وتغيّر getters/setters والـ JSP والـ Controller بنفس الأسماء.

---

# كيف تغيّر Item إلى Game؟

الحقول مثلًا:

```java
private String title;
private String genre;
private Double price;
```

أو حسب السؤال المكتوب.

---

# CRUD Routes التي لازم تحفظها

```text
GET  /dashboard
GET  /items/new
POST /items
GET  /items/{id}
GET  /items/{id}/edit
POST /items/{id}/update
POST /items/{id}/delete
```

---

# Login Routes

```text
GET  /
POST /register
POST /login
GET  /logout
```

---

# أكثر أخطاء الامتحان شيوعًا

## 1. Database غير موجودة

```text
Unknown database
```

الحل:

```sql
CREATE DATABASE exam_app_db;
```

## 2. JSP لا يفتح

تأكد أن الملفات هنا:

```text
src/main/webapp/WEB-INF/
```

وتأكد:

```properties
spring.mvc.view.prefix=/WEB-INF/
spring.mvc.view.suffix=.jsp
```

## 3. Error في ModelAttribute

الاسم لازم يكون نفسه:

```java
model.addAttribute("item", new Item());
```

```jsp
modelAttribute="item"
```

```java
@ModelAttribute("item")
```

## 4. BindingResult

لازم يأتي مباشرة بعد `@Valid`:

```java
@Valid @ModelAttribute("item") Item item,
BindingResult result
```

## 5. Date Error

إذا عندك Date استخدم:

```java
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date date;
```

وفي JSP:

```jsp
<form:input path="date" type="date"/>
```

---

# خطة سريعة في الامتحان

1. اقرأ السؤال وحدد اسم الـ Entity والحقول.
2. أنشئ قاعدة البيانات.
3. عدّل `application.properties`.
4. اعمل `User` و `LoginUser`.
5. اعمل Entity السؤال: Game أو Book أو Product.
6. Repository.
7. Service.
8. Controller.
9. JSP.
10. Run.
11. جرّب Register.
12. جرّب Login.
13. جرّب Create.
14. جرّب View.
15. جرّب Edit.
16. جرّب Delete.
