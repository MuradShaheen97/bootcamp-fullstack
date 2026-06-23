# Device Project

## Overview
This project demonstrates inheritance in Java by creating a `Device` class and a `Phone` class that extends it. The phone tracks battery usage while performing different actions.

## Features
- Device starts with 100% battery.
- Make calls (-5 battery).
- Play games (-20 battery).
- Charge phone (+50 battery).
- Display battery status.
- Show "Battery critical!" when battery is below 10%.
- Prevent playing games when battery is below 25%.

## Project Structure

DeviceProject/
├── Device.java
├── Phone.java
└── DeviceTest.java

## How to Run

Compile the project:

```bash
javac *.java