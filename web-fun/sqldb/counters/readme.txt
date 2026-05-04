

# 🌍 MySQL Countries Queries Project

## 📌 Overview
/
This project is part of my **Web Fundamentals journey at AXSOS Academy**, where I practiced writing SQL queries using the **World Database**.

The goal was to understand how to:

* Work with real-world relational data
* Use **JOINs** to connect tables
* Apply **filters (WHERE)**
* Use **aggregation (COUNT, GROUP BY)**
* Sort results using **ORDER BY**

---

## 🧠 Database Structure (ERD)

The database consists of 3 main tables:

* **countries**
* **cities**
* **languages**

### 🔗 Relationships

* `countries.id = cities.country_id`
* `countries.id = languages.country_id`

This structure allows us to:

* Link countries with their cities
* Link countries with spoken languages

---

## ⚙️ Technologies Used

* MySQL
* MySQL Workbench
* SQL (Structured Query Language)

---

## 📊 Queries Implemented

### 1. Countries that speak Slovene

* Retrieved country name, language, and percentage
* Sorted by percentage (DESC)

---

### 2. Total number of cities per country

* Used `COUNT()` and `GROUP BY`
* Sorted by number of cities (DESC)

---

### 3. Cities in Mexico with population > 500,000

* Filtered by country and population
* Sorted by population (DESC)

---

### 4. Languages with percentage > 89%

* Joined countries with languages
* Filtered high-percentage languages

---

### 5. Countries with:

* Surface Area < 501
* Population > 100,000

---

### 6. Constitutional Monarchies with:

* Capital > 200
* Life Expectancy > 75

---

### 7. Cities in Argentina (Buenos Aires district)

* Population > 500,000
* Returned country, city, district, and population

---

### 8. Number of countries per region

* Used `GROUP BY region`
* Counted countries in each region
* Sorted descending

---

## 💡 What I Learned

This assignment helped me understand:

* How relational databases actually work
* The power of **JOIN operations**
* How to extract meaningful insights from data
* Writing clean and structured SQL queries

---

## 🚀 My Perspective

I didn’t approach this as just an assignment.

I approached it as:

> Learning how to **ask the database the right questions**

Because in real-world development:

* Data is everywhere
* But value comes from how you **query and understand it**

---

## 👤 Author

**Murad Shaheen**
Full Stack Developer Student | Business-Minded Problem Solver

🔗 [LinkedIn](https://www.linkedin.com/in/muradshaheen/)
🔗 [GitHub](https://github.com/MuradShaheen97)

---


