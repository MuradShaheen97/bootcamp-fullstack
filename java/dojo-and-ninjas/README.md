# Dojo and Ninjas Assignment

## Description

This project is a Spring Boot MVC application that demonstrates a One-to-Many relationship.

One Dojo can have many Ninjas.

## Features

- Create a new Dojo
- Create a new Ninja
- Choose Dojo from dropdown
- Show all Ninjas that belong to one Dojo

## Routes

| Method | Route | Description |
|---|---|---|
| GET | /dojos/new | Display new dojo form |
| POST | /dojos/new | Create dojo |
| GET | /ninjas/new | Display new ninja form |
| POST | /ninjas/new | Create ninja |
| GET | /dojos/{id} | Show dojo and its ninjas |

## Database

### dojos

- id
- name
- created_at
- updated_at

### ninjas

- id
- first_name
- last_name
- age
- dojo_id
- created_at
- updated_at

## Relationship

One Dojo has many Ninjas.

```java
@OneToMany(mappedBy = "dojo")
private List<Ninja> ninjas;