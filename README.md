| CS-665       | Software Design & Patterns |
| ------------ | -------------------------- |
| Name         | ALISA BELOUSOVA            |
| Date         | 10/10/2023                 |
| Course       | Fall                       |
| Assignment # | 2                          |

# Assignment Overview

In this assignment, our primary objective is to design and implement a system simulating a delivery request platform, where various shops can create delivery requests and notify available drivers about them. Utilizing the Observer design pattern, we aim to achieve a loosely-coupled architecture between shops and drivers, ensuring that adding, modifying, or removing either entity does not affect the other. This enhances the system’s flexibility and scalability, making it adaptable to future changes or expansions, like introducing different kinds of observers or subjects.

### Assumptions

1. Observer Management: Observers are correctly managed (added and removed) by the client code using `registerObserver` and `removeObserver`.
2. Update Mechanism: The `update()` method is the only way `Driver` objects receive and store `DeliveryRequest` objects.
3. Validation: Input validation (e.g., checking for null or invalid address/product strings) is not implemented.
4. Communication: The observer pattern is used for one-to-many communication from `Shop` to multiple `Driver` instances and assumes all observers need to be notified when a delivery request is created.
5. Scalability: The code is designed for relatively small-scale applications where potential performance bottlenecks (e.g., iterating through all observers) are not a critical issue.
6. Data Persistence: Data persistence (e.g., saving delivery requests or driver responses to a database) is not managed.

# GitHub Repository Link:

https://github.com/alisa007/cs-665-assignment-2

# Implementation Description

## Flexibility

The implemented delivery system possesses a high degree of flexibility, primarily due to the use of the Observer design pattern. This pattern ensures that our `Shop` (subject) and `Driver` (observer) classes are loosely coupled. This means adding new observers (like perhaps, self-driving cars in the future) or modifying existing ones won’t necessitate changes in the `Shop` class, enhancing the system's adaptability to evolving requirements.

## Simplicity and Understandability:

The codebase is structured with simplicity and clarity in mind. Clear class and variable naming conventions, along with comprehensive documentation, ensures that the functionality of each class and method is easily discernible. Further, by adhering to the Single Responsibility Principle, each class is designed to encapsulate a single functionality, making the codebase easy to understand and navigate.

## Avoidance of Duplicated Code:

Duplicated code has been meticulously avoided through the conscientious use of methods and classes, ensuring that each functionality is implemented once and reused as necessary. For instance, notification logic is embedded within the `Shop` class and not duplicated across various `Driver` instances. This not only aids in maintaining and modifying the codebase but also in reducing the probability of introducing errors.

## Design Patterns Used:

The Observer design pattern is employed in this implementation to establish a one-to-many dependency between objects, so that when one object changes state, all its dependents are notified and updated automatically. This pattern was chosen for its ability to effectively decouple the `Shop` (subject) from the `Driver` (observer). Consequently, shops can notify drivers of delivery requests without needing to know anything about the drivers themselves. This decoupling between classes adheres to the Open/Closed Principle, enabling the easy addition of new observer types in the future without modifying existing code.

# Commands

## Compile

Type on the command line:

```bash
mvn clean compile
```

## JUnit Tests

To run, use the following command:

```bash
mvn clean test
```

## Spotbugs

Use the following command:

```bash
mvn spotbugs:gui 
```

## Checkstyle

The following command will generate a report in HTML format that you can open in a web browser.

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`
