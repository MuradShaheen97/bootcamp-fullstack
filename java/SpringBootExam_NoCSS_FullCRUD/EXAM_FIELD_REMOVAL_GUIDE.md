# Exam Field Removal Guide

## Item CRUD fields

### Remove `city`
1. `models/Item.java`: remove `city`, its annotations, getter, and setter.
2. `controllers/ItemController.java`: remove `oldItem.setCity(formItem.getCity());`.
3. `new.jsp`: remove the city label/input/errors block.
4. `edit.jsp`: remove the city label/input/errors block.
5. `show.jsp`: remove the City paragraph.
6. `dashboard.jsp`: remove the City `<th>` and matching `<td>`.
7. Optional MySQL cleanup: `ALTER TABLE items DROP COLUMN city;`.

### Remove `eventDate`
1. `models/Item.java`: remove `eventDate`, its annotations, getter/setter, and `LocalDate`/`DateTimeFormat` imports if unused.
2. `ItemController.java`: remove `oldItem.setEventDate(formItem.getEventDate());`.
3. Remove Date from `new.jsp`, `edit.jsp`, `show.jsp`, and `dashboard.jsp`.
4. Optional: `ALTER TABLE items DROP COLUMN event_date;`.

### Remove `price`, `name`, or `description`
Use the same pattern: Model field + validation + getter/setter, update setter in controller, and every matching JSP input/output.

## Registration fields

### Remove User `city`
1. `models/User.java`: remove city field, validation, getter, setter.
2. `login.jsp`: remove registration city input and errors.
3. Any page displaying user city: remove that output.
4. Optional: `ALTER TABLE users DROP COLUMN city;`.

### Remove User `dateOfBirth`
1. Remove field, annotations, getter/setter from `User.java`.
2. Remove the date input/errors from `login.jsp`.
3. Remove `LocalDate` and `DateTimeFormat` imports only if no other field uses them.

### Remove `username`
1. Remove username field/getter/setter from `User.java`.
2. Remove `findByUsername` from `UserRepository.java`.
3. Remove username uniqueness validation from `UserService.register()`.
4. Remove username input/errors from `login.jsp`.

## Important database note
`spring.jpa.hibernate.ddl-auto=update` creates and updates tables automatically, but it may keep an old column after you remove a Java field. The project can still run. Drop the old column manually only when you need a perfectly clean database.
