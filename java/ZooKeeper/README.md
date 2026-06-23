# Zoo Keeper

## Description

A Java application that demonstrates inheritance using a Mammal superclass and two subclasses: Gorilla and Bat.

## Features

### Mammal
- Starts with 100 energy.
- Displays current energy level.

### Gorilla
- throwSomething() → -5 energy
- eatBananas() → +10 energy
- climb() → -10 energy

### Bat
- Starts with 300 energy.
- fly() → -50 energy
- eatHumans() → +25 energy
- attackTown() → -100 energy

## Project Structure

```text
ZooKeeper/
│
├── Mammal.java
├── Gorilla.java
├── Bat.java
└── ZooKeeperTest.java
```

## How to Run

```bash
javac *.java
java ZooKeeperTest
```

## Checklist

- [x] Create Mammal class
- [x] Create Gorilla class
- [x] Create Bat class
- [x] Implement displayEnergy()
- [x] Test Gorilla actions
- [x] Test Bat actions
- [x] Demonstrate inheritance