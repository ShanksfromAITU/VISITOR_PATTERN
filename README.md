# Assignment 6 — Visitor Pattern


## Overview

This Java project implements the Visitor Design Pattern using three shapes:
Circle, Square, and Triangle.

Three visitors perform different operations on the same collection:

- `AreaCalculatorVisitor` calculates the total area.
- `ExportVisitor` creates a text representation of the shapes.
- `PerimeterCalculatorVisitor` calculates the total perimeter.

New operations can be added by implementing `ShapeVisitor` without modifying
the existing shape classes.

## Project Structure

- `src/app` — application entry point and collection traversal.
- `src/elements` — Shape interface, concrete shapes, and dimension validation.
- `src/visitors` — ShapeVisitor interface and three concrete visitors.

## How It Works

Each shape implements `accept(ShapeVisitor visitor)`.
Inside this method, the shape calls the corresponding visitor method:

```java
@Override
public void accept(ShapeVisitor visitor) {
    visitor.visitCircle(this);
}
```

This implements double dispatch: the concrete shape selects the matching
visit method, and the concrete visitor provides the operation.

## Requirements

- JDK 17 or later.
- IntelliJ IDEA or a terminal with `java` and `javac` available.
- No external libraries are required.

## Run

In IntelliJ IDEA, open the project, select JDK 17 or later, and run
`src/app/Main.java`.

Alternatively, execute these commands from the project root:

```bash
javac -d out src/app/*.java src/elements/*.java src/visitors/*.java
java -cp out app.Main
```

## Expected Output

```text
=== Shape Export ===
Circle: radius=5.00
Square: side=4.00
Triangle: sides=3.00, 4.00, 5.00

=== Calculations ===
Total area: 100.54
Total perimeter: 59.42
```

## Clean Code

The project applies principles from Chapters 12 and 13:

- **Contains No Duplication:** shared dimension validation is placed in
  `ShapeValidation`.
- **Expresses Intent:** descriptive names and short methods explain the code.
- **Minimizes Classes and Methods:** the design uses the necessary pattern
  components and one shared validation helper.
- **Limit Data Scope:** visitor results are private instance fields.
- **Read-Only Data:** shapes have private final dimensions and no setters;
  the collection is created using `List.of()`.

The application runs sequentially. Visitors accumulate mutable results,
so each independent calculation should use a new visitor instance.
A mutable visitor instance should not be shared between concurrent tasks
without synchronization.

## Design Trade-offs

Visitors access shape dimensions through getters, while the fields remain
private and final.

Adding a new visitor does not require changes to the shape classes.
Adding a new shape type requires updating `ShapeVisitor` and all concrete
visitors.