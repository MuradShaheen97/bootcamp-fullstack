# Save Travels

A Spring Boot CRUD application for tracking travel expenses.

## Features

- View all expenses
- Add new expense
- Validate form inputs
- Edit expense
- Delete expense
- Show expense details

## Routes

| Method | Route | Description |
|---|---|---|
| GET | /expenses | Show all expenses |
| POST | /expenses | Create expense |
| GET | /expenses/{id} | Show expense details |
| GET | /expenses/edit/{id} | Edit page |
| PUT | /expenses/{id} | Update expense |
| DELETE | /expenses/{id} | Delete expense |

## Database

Create schema:

```sql
CREATE SCHEMA save_travels_schema;