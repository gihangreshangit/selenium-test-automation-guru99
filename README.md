# selenium-test-automation

Selenium WebDriver test automation framework using Java, Maven and TestNG.

A lightweight, configurable TestNG + Selenium framework scaffolded with Maven to structure UI tests, manage dependencies, run suites locally or in CI, and generate test reports.

## Table of Contents

- [Features](#features)
- [Tech stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Quick start](#quick-start)
- [Configuration](#configuration)
- [Running tests](#running-tests)
- [Project structure](#project-structure)
- [Writing tests](#writing-tests)
- [Reports & logs](#reports--logs)
- [Continuous integration](#continuous-integration)
- [Contributing](#contributing)
- [License & contact](#license--contact)

## Features

- TestNG test runner with XML suite support
- Maven build and dependency management
- Cross-browser execution (Chrome, Firefox, Edge — configurable)
- Support for headless execution
- Configurable test parameters (browser, baseUrl, environment, headless)
- Test reports via TestNG / Surefire (extendable to Allure or custom reporters)
- Page Object Model friendly structure

## Tech stack

- Java 11+ (works with later versions; adjust settings if using Java 17+)
- Maven
- TestNG
- Selenium WebDriver
- (Optional) WebDriverManager (recommended) or local browser drivers

## Prerequisites

- Java JDK installed and JAVA_HOME configured
- Maven installed (mvn on PATH)
- A supported browser installed (Chrome, Firefox, Edge) or use remote/grid
- Optionally: WebDriverManager dependency (recommended) to auto-manage driver binaries

Verify versions:
- java -version
- mvn -v

## Quick start

1. Clone the repository:
   git clone https://github.com/gihanmadurapriya/selenium-test-automation.git
   cd selenium-test-automation

2. Run the full test suite (default):
   mvn clean test

3. Run a specific TestNG suite:
   mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml

4. Run a single test class or method:
   mvn -Dtest=YourTestClass test
   mvn -Dtest=YourTestClass#yourTestMethod test

5. Run with custom parameters (examples):
   - Specify browser:
     mvn clean test -Dbrowser=chrome
   - Headless:
     mvn clean test -Dbrowser=chrome -Dheadless=true
   - Run only smoke tests (if grouped):
     mvn clean test -Dgroups=smoke

(Adjust property names to match your test framework's config if different.)

## Configuration

This project expects configuration values to be read from one of the following (choose one or combine as implemented):

- src/test/resources/config.properties (recommended)
- System properties passed via -D (e.g., -Dbrowser=firefox)
- Environment variables

Common configuration properties:
- browser — chrome|firefox|edge
- baseUrl — application base URL
- headless — true|false
- timeout — implicit/explicit default timeout in seconds
- env — dev|qa|prod

Example config.properties:
browser=chrome
baseUrl=https://example.com
headless=false
timeout=10

Tip: Use WebDriverManager in your setup to avoid manual driver downloads:
- io.github.bonigarcia:webdrivermanager

## Running tests in CI / headless servers

- Use headless mode and set browser binaries / drivers appropriately.
- Example:
  mvn clean test -Dbrowser=chrome -Dheadless=true

- If using a Selenium Grid or remote WebDriver, set remote URL:
  -DremoteUrl=http://grid-host:4444/wd/hub

## Project structure (recommended / typical)

- src/main/java
  - framework utilities, base classes (BaseTest, DriverFactory, utils)
- src/test/java
  - tests and page objects
- src/test/resources
  - testng.xml, config.properties, test data
- pom.xml
  - Maven configuration and dependencies
- target/
  - build outputs and test reports

Adjust to match this repository's current layout if different.

## Writing tests

- Follow Page Object Model (POM) to keep tests readable and maintainable.
- Example minimal TestNG test (outline):

```java
public class LoginTest extends BaseTest {
    @Test
    public void loginWithValidCredentials() {
        LoginPage login = new LoginPage(driver);
        HomePage home = login.login("user@example.com","password");
        assertTrue(home.isLoggedIn());
    }
}
