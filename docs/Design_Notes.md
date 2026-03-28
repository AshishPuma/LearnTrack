# Design Notes

## 1. Why ArrayList instead of Array?

ArrayList is used because it is dynamic in size.
Unlike arrays, we do not need to define the size beforehand.
Since the number of students, courses, and enrollments can grow over time, ArrayList is a better choice.

---

## 2. Where static members are used and why

Static is used in the `IdGenerator` class.

Example:

* studentIdCounter
* courseIdCounter
* enrollmentIdCounter

These are static because we want a single shared counter across the entire application.
This ensures that every new entity gets a unique ID.

---

## 3. Where inheritance is used and its benefit

Inheritance is used in:

* `Student extends Person`
* `Trainer extends Person`

The `Person` class contains common fields like:

* id
* firstName
* lastName
* email

By using inheritance, we avoid code duplication and reuse common properties and methods.

---

## 4. Layered Architecture

The project follows a layered design:

* Entity → represents data (Student, Course, Enrollment)
* Repository → handles data storage
* Service → contains business logic
* Main → handles user interaction

This separation makes the code clean, easy to understand, and maintainable.
