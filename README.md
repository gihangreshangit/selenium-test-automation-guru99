# Selenium Test Automation Project

## Overview

This project demonstrates web UI test automation using **Java, Selenium WebDriver, Maven, and TestNG**.

The project automates the login functionality of the **Guru99 Demo Bank** application and includes both positive and negative login test scenarios.

This project was created as a learning and portfolio project to demonstrate fundamental QA automation skills.

## Technologies Used

* Java
* Selenium WebDriver
* TestNG
* Maven
* Google Chrome
* Git
* GitHub

## Project Structure

```text
SeleniumProject/
│
├── pom.xml
├── README.md
├── .gitignore
│
└── src/
    └── test/
        └── java/
            └── guru99Test.java
```

## Test Scenarios

### 1. Successful Login

**Objective:** Verify that a user can log in using valid credentials.

**Test steps:**

1. Open the Guru99 Demo Bank login page.
2. Enter a valid user ID.
3. Enter a valid password.
4. Click the Login button.
5. Verify that the expected Manager ID is displayed.

### 2. Unsuccessful Login

**Objective:** Verify that the system displays an error message when an invalid password is entered.

**Test steps:**

1. Open the Guru99 Demo Bank login page.
2. Enter a valid user ID.
3. Enter an invalid password.
4. Click the Login button.
5. Verify that the expected error alert is displayed.

## Automation Features

The project demonstrates:

* Selenium WebDriver browser automation
* TestNG test annotations
* `@BeforeMethod` test setup
* Multiple test cases
* Selenium locators
* Web element interaction
* Positive and negative testing
* TestNG assertions
* Maven test execution
* Basic browser lifecycle management

## TestNG Annotations Used

```java
@BeforeMethod
```

Used to open the browser and navigate to the login page before each test.

```java
@Test
```

Used to define automated test cases.

```java
@AfterMethod
```

Used to close the browser after each test.

## How to Run the Tests

### Prerequisites

Make sure the following are installed:

* Java JDK
* Maven
* Google Chrome
* Visual Studio Code or another Java IDE

### Clone the Repository

After cloning the repository, open the project directory in VS Code.

### Run the Tests

Open the terminal in the project directory:

```bash
mvn clean test
```

Maven will compile the project and execute the TestNG tests.

## Expected Result

A successful test execution should show:

```text
Tests run: 2
Failures: 0
Errors: 0
Skipped: 0
BUILD SUCCESS
```

## Future Improvements

The project will be extended with more advanced automation concepts, including:

* Page Object Model (POM)
* Explicit waits
* Data-driven testing
* Additional test scenarios
* Screenshot capture on test failure
* Test reporting
* Cross-browser testing
* Continuous Integration using GitHub Actions

## Learning Objective

The main objective of this project is to develop practical experience with web automation testing and gradually build a maintainable Selenium test automation framework.

## Author

**Gihan Greshan Madurapriya**

Software Engineering Undergraduate
QA / Software Testing Enthusiast
