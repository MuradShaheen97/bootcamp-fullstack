# Art Project

## Description
This project demonstrates the use of Abstract Classes, Inheritance, Polymorphism, and ArrayLists in Java.

## Classes

### Art (Abstract Class)
Member Variables:
- title
- author
- description

Abstract Method:
- viewArt()

### Painting
Extends Art and adds:
- paintType

### Sculpture
Extends Art and adds:
- material

## Project Structure

```text
ArtProject/
│
├── Art.java
├── Painting.java
├── Sculpture.java
└── Museum.java
```

## Features

- Create an abstract Art class.
- Create Painting and Sculpture subclasses.
- Override the viewArt() method.
- Store artworks in an ArrayList<Art>.
- Shuffle the museum collection.
- Display all artwork information.

## How to Run

```bash
javac *.java
java Museum
```

## Concepts Practiced

- Abstract Classes
- Abstract Methods
- Inheritance
- Polymorphism
- ArrayList
- Collections.shuffle()
- Method Overriding

## Checklist

- [x] Create Art abstract class
- [x] Create abstract viewArt() method
- [x] Create Painting class
- [x] Create Sculpture class
- [x] Create 3 Paintings
- [x] Create 2 Sculptures
- [x] Store objects in ArrayList<Art>
- [x] Shuffle museum collection
- [x] Display artwork information