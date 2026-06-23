# CareSoft HIPAA Compliance

## Description

This project demonstrates the implementation of Java interfaces in a healthcare management system called CareSoft. The application follows HIPAA compliance requirements by validating user PINs, authorizing access, and reporting security incidents.

---

## Features

### HIPAACompliantUser
- Assign PINs based on role requirements.
- Verify user authorization.

### Physician
- PIN must be exactly 4 digits.
- Access is authorized only when IDs match.

### AdminUser
- PIN must be at least 6 digits.
- Unauthorized access attempts are logged as security incidents.
- Security incidents can be reported.

### HIPAACompliantAdmin
- Generate a report of all security incidents.

---

## Project Structure

```text
CareSoft/
│
├── HIPAACompliantUser.java
├── HIPAACompliantAdmin.java
├── Physician.java
├── AdminUser.java
└── CareSoftTest.java
```

---

## How to Run

Compile all files:

```bash
javac *.java
```

Run the test class:

```bash
java CareSoftTest
```

---

## Example Output

```text
true
false
true
false
----------------------
true
false
true
false
[Unauthorized access attempt with ID: 100]
```

---

## Concepts Practiced

- Interfaces
- Inheritance
- Polymorphism
- ArrayList
- Encapsulation
- Method Overriding
- Access Control

---

## Checklist

- [x] Implement HIPAACompliantUser interface
- [x] Implement HIPAACompliantAdmin interface
- [x] Create Physician class
- [x] Create AdminUser class
- [x] Validate Physician PIN (4 digits)
- [x] Validate Admin PIN (6+ digits)
- [x] Implement authorization checks
- [x] Log security incidents
- [x] Generate incident reports
- [x] Test all functionality