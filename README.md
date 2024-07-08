# QA - Assessment Exercise: 1

This project is a Java-based automated testing framework that utilizes Maven for build management, Selenium for browser automation, and Cucumber for behavior-driven development (BDD) testing.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running Tests](#running-tests)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Notes](#notes)

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java JDK 8 or higher
- Maven 3.6.0 or higher
- An IDE like IntelliJ IDEA or Eclipse
- Firefox or Google Chrome browser installed

## Installation

1. **Clone the repository**:

    ```bash
    git clone 'git-repository'
    cd qa_test_assessment_ui
    ```

2. **Install dependencies**:

    ```bash
    mvn clean install
    ```

## Running Tests

You can run the tests using Maven. Here are a few commands to help you get started:

1. **Run all tests**:

    ```bash
    mvn test
    ```

2. **Run tests with a specific Cucumber tag**:

    ```bash
    mvn test -Dcucumber.options="--tags @yourTag"
    ```

3. **Generate Cucumber reports**:

   After running tests, you can generate reports using:

    ```bash
    mvn verify
    ```

## Project Structure

The project follows a standard Maven structure:

```
qa_test_assessment
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
│       ├── java
│       │   ├── features
│       │   ├── pageObjects
│       │   ├── stepDefinitions
│       │   ├── testRunners
│       │   └──utilities
│       └── resources
│               └── reports
├── target
├── .gitignore
├── pom.xml
├── README.md
└── testng.xml
```

- **src/main/java**: Contains the main application code.
- **src/test/java**: Contains the test runners, step definitions, and feature files.

## Configuration

### Selenium WebDriver Configuration

Selenium WebDriver configurations such as browser type, driver paths, and other settings can be managed in the `config.properties` file located in the `src/test/resources` directory.

### Cucumber Options

Cucumber options such as report formats, tags, and glue paths can be configured in the `TestRunner.java` file.

## Notes

- A `config.properties` file can be created and located in the `src/test/resources` directory to manage Selenium WebDriver configurations such as browser type, driver paths, and other settings.
- I have set Firefox as the default browser for running tests. However, it is possible to implement more dynamic methods for selecting the browser, allowing for greater flexibility in executing the tests.
- A utility to take screenshot can be really useful, in particular for test failures.
- The report can be generated with a dynamic name for better organization and traceability.
- Logs should be managed efficiently to ensure clear and effective debugging and monitoring.
