# Library Management System

This project is a simple Library Management System built with Python and Object-Oriented Programming.

The system can manage different library items such as books, magazines, and DVDs.  
Each item can be borrowed, returned, checked for availability, and can calculate a late fee.

## Files

- `library_item.py` contains the main abstract class.
- `book.py` contains the Book class.
- `magazine.py` contains the Magazine class.
- `dvd.py` contains the DVD class.
- `main.py` is used to test the system.

## OOP Concepts Used

### Inheritance

Book, Magazine, and DVD inherit from LibraryItem.

### Encapsulation

Each class keeps its own data and behavior inside the class.

### Polymorphism

Each item has the same method `calculate_late_fee()`, but each one calculates it differently.

### Abstraction

LibraryItem is an abstract class that forces all child classes to implement late fee calculation.

## How to Run

Run this command:

```bash
python main.py
```
