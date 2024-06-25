# KYZBankProject - Automation Suite with Selenium and Java

## 🚀 Description
The KYZBank project is an automation test suite for a web banking application, using Selenium and Java. This project is designed to demonstrate skills in automated testing, test case design, and test framework development.

## 📂 Project Structure
```
KYZBankProject
│
├── drivers
│   └── chromedriver.exe
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── pages
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── CustomerLoginPage.java
│   │   │   │   ├── AccountPage.java
│   │   │   │   └── TransactionPage.java
│   │   │   └── utils
│   │   │       └── WebDriverUtils.java
│   │   └── resources
│   │       └── config.properties
│   │
│   └── test
│       ├── java
│       │   ├── tests
│       │   │   └── KYZBankTest.java
│       │   └── base
│       │       └── TestBase.java
│       └── resources
│           └── testData.xlsx
│
└── pom.xml
```
## 🏗️ Design Patterns

### 📚 Page Object Model (POM) pattern

We implemented the **Page Object Model (POM)** ​​pattern to separate the testing logic from the user interface. Each web page is encapsulated in its own Java class, which facilitates **change management** and improves **reusability** of the code.

### 📁 Directory Structure

The organization of our directories is clear and logical, allowing intuitive navigation through the project:

- **`/drivers`**: Contains browser drivers, guaranteeing consistency in testing.
- **`/src/main/java`**: Hosts the page and utility classes, forming the core of our automation operations.
- **`/src/test/java`**: Includes the test classes and the base class, where the magic of testing happens.
- **`/resources`**: Stores configuration files and test data, essential for the execution of our test suites.

### 🛠️ Maven as Dependency Manager

We use **Maven** for dependency management, allowing for effortless test environment setup and easy integration with **CI/CD** systems.

## 🧠 Classes and their Purpose

- **HomePage.java**: Represents the bank's home page with methods to navigate to the customer's login page.
- **CustomerLoginPage.java**: Represents the customer login page with methods to perform the login.
- **AccountPage.java**: Represents the client's account page with methods to perform operations such as deposits and withdrawals.
- **TransactionPage.java**: Represents the transaction page with methods to verify transaction details.
- **WebDriverUtils.java**: Contains common utilities to interact with the browser, such as WebDriver initialization.
- **TestBase.java**: Base class for testing that configures the test environment and handles global configuration.
- **KYZBankTest.java**: Contains the test cases that use the page classes to interact with the web application.

## 📝 Additional Files

- **config.properties**: Stores project settings, such as the WebDriver path and page URLs.

## ⚙️ How to Run Tests

To run the tests, you will need to have Java and Maven installed.

## 🤝 Contributions
Contributions are welcome. If you want to contribute to the project, please fork the repository, make your changes and submit a pull request.

