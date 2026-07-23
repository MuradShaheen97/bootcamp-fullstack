# Exam Quick Reference

## Rename Table

| Generic | Example |
|---|---|
| Item | Game |
| item | game |
| items | games |
| /items | /games |
| ItemRepository | GameRepository |
| ItemService | GameService |
| ItemController | GameController |

## Build Order

1. Model
2. Repository
3. Service
4. Controller
5. JSP
6. application.properties
7. Database
8. Run

## Database

```sql
CREATE DATABASE exam_app_db;
```

## Important

- `BindingResult` must come directly after `@Valid @ModelAttribute`.
- JSP `modelAttribute` must match the Controller attribute name.
- JSP field paths must match Model field names.
