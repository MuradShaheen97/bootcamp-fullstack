# COFFEAPP

## Overview

COFFEAPP is a console-based Java application that simulates a simple coffee shop ordering system. The application allows customers to view a menu, create orders, add menu items to their orders, and view an order summary with the total cost.

This project demonstrates:

* Object-Oriented Programming (OOP)
* Classes and Objects
* Encapsulation
* ArrayLists
* User Input with Scanner
* Constructors
* Getters and Setters
* Business Logic Separation
* Interactive Console Applications

---

## Features

### Customer Features

* View available menu items
* Create a new order
* Add multiple items to an order
* Exit item selection using `q`
* View order summary
* View total order cost

### Administrator Features (Ninja Bonus)

* Add new menu items through terminal input

---

## Technologies Used

* Java
* ArrayList
* Scanner
* Object-Oriented Programming (OOP)

---

## Project Structure

```text
COFFEAPP/
│
├── Item.java
│
├── Order.java
│
├── CoffeeKiosk.java
│
└── TestCoffeeKiosk.java
```

---

## Class Descriptions

### Item.java

Represents a menu item.

#### Attributes

| Attribute | Type   |
| --------- | ------ |
| name      | String |
| price     | double |
| index     | int    |

#### Methods

* getName()
* getPrice()
* getIndex()
* setIndex()

---

### Order.java

Represents a customer order.

#### Attributes

| Attribute | Type            |
| --------- | --------------- |
| name      | String          |
| items     | ArrayList<Item> |
| ready     | boolean         |

#### Methods

* addItem()
* getOrderTotal()
* getStatusMessage()
* setReady()
* display()

---

### CoffeeKiosk.java

Handles menu management and user interaction.

#### Attributes

| Attribute | Type             |
| --------- | ---------------- |
| menu      | ArrayList<Item>  |
| orders    | ArrayList<Order> |
| scanner   | Scanner          |

#### Methods

##### addMenuItem()

Adds a new item to the menu and automatically assigns its index.

##### displayMenu()

Displays all menu items.

Example:

```text
0 banana -- $2.00
1 coffee -- $1.50
2 latte -- $4.50
3 capuccino -- $3.00
4 muffin -- $4.00
```

##### newOrder()

Creates a new customer order.

The user:

1. Enters their name.
2. Selects menu items using menu indexes.
3. Types `q` when finished.
4. Receives an order summary.

##### addMenuItemByInput()

Allows an administrator to add menu items through terminal input.

---

### TestCoffeeKiosk.java

Contains the main method used to test the application.

Responsibilities:

* Create CoffeeKiosk object
* Add menu items
* Launch ordering process
* Test application functionality

---

## Installation

### Clone or Download

Download the project and open it in your Java IDE.

Examples:

* VS Code
* IntelliJ IDEA
* Eclipse

---

## Compile

```bash
javac *.java
```

---

## Run

```bash
java TestCoffeeKiosk
```

---

## Sample Execution

```text
Please enter customer name for new order:
Murad

===== MENU =====

0 banana -- $2.00
1 coffee -- $1.50
2 latte -- $4.50
3 capuccino -- $3.00
4 muffin -- $4.00

Please enter a menu item index or q to quit:
1

coffee added to order.

Please enter another menu item index or q to quit:
2

latte added to order.

Please enter another menu item index or q to quit:
q

===== ORDER SUMMARY =====

Customer Name: Murad

coffee -- $1.50
latte -- $4.50

Total: $6.00
```

---

## Learning Objectives

Through this project, students practice:

* Creating custom Java classes
* Working with object relationships
* Managing collections using ArrayList
* Receiving user input
* Using loops and conditionals
* Separating business logic into classes
* Building interactive console applications

---

## Assignment Requirements Checklist

### Required

* Create Item class
* Add index property to Item
* Create CoffeeKiosk class
* Create menu ArrayList
* Create orders ArrayList
* Implement addMenuItem()
* Implement displayMenu()
* Implement newOrder()
* Allow user to enter menu item indexes
* Allow user to quit using q
* Print order details

### Ninja Bonus

* Implement addMenuItemByInput()

---

## Author

Murad Shaheen

AXSOS Academy – Full Stack Development Program
