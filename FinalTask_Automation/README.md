# 🧪 SauceDemo Login Test Automation Suite

This project automates the login functionality of [SauceDemo](https://www.saucedemo.com) using:

- 🧰 **Selenium WebDriver**
- 🧪 **JUnit 5 & Cucumber**
- 🧼 **Maven** as build tool
- 🌐 **Firefox** & **Edge** browser support
- ✅ **Hamcrest** for assertions
- 🔍 **SLF4J** logging
- ♻️ **Strategy Pattern** for browser switching
- 🧱 Page Object Model (POM) design

---

## 📁 Project Structure

```
FinalTask/
├── pom.xml
├── README.md
├── src/
│   └── test/
│       ├── java/
│       │   └── com.epam.training.student_david_makatsaria/
│       │       ├── base/
│       │       ├── data/
│       │       ├── pages/
│       │       ├── runner/
│       │       ├── steps/
│       │       ├── tests/
│       │       └── util/strategy/
│       └── resources/
│           └── features/
│               └── login.feature
```

---

## 🚀 How to Run

### 🔧 Pre-requisites

- Java 17+
- Maven 3.8+
- GeckoDriver (for Firefox) or MSEdgeDriver (for Edge) installed and added to your system `PATH`

---

### 🧪 Run BDD Tests (Cucumber)

```bash
mvn test -Dtest=CucumberTest
```

### 🌐 Run in Edge:

```bash
mvn test -Pedge -Dtest=CucumberTest
```

### 🧪 Run Classic Unit Tests (JUnit style):

```bash
mvn test -Dtest=LoginTests
```

---

## 🎯 Test Scenarios Covered

### ✅ UC-1: Empty Credentials
- Fill in dummy username and password
- Clear the fields
- Click login
- Assert error: **"Username is required"**

### ✅ UC-2: Missing Password
- Fill in dummy username and password
- Clear only the password field
- Click login
- Assert error: **"Password is required"**

### ✅ UC-3: Valid Credentials
- Use accepted usernames (e.g. `standard_user`, `problem_user`)
- Password: `secret_sauce`
- Assert page title: **"Swag Labs"**

---

## 🔄 Browser Selection

This project uses a **Strategy pattern** and `-Dbrowser` system property to select a browser.

### Available options:
- `firefox` (default)
- `edge`

Use in CLI:
```bash
mvn test -Dbrowser=firefox
```

Or use Maven profiles:
```bash
mvn test -Pedge -Dtest=CucumberTest
```

---

## 🪵 Logging

Logging is handled using **SLF4J** (Simple implementation). Logs will print test progress and credentials in use.

---

## 🧹 Browser Cleanup

All tests auto-close the browser after completion:
- Cucumber: using `@After` hook in `LoginSteps.java`
- JUnit: using `@AfterEach` in `BaseTest.java`

---

## ❓ Troubleshooting

### ✅ Browser opens in IDE but not via `mvn test`
- Ensure `geckodriver` or `msedgedriver` is installed and in your system `PATH`.

### ✅ Cucumber steps show as undefined
- Ensure feature file matches step definitions exactly.
- Check glue path in `CucumberTest.java`:
  ```java
  glue = {"com.epam.training.student_david_makatsaria.steps"}
  ```

### ✅ Browser stays open
- Ensure `DriverFactory.quitDriver()` is called in `@After` method.

---

## ✍️ Author
David Makatsaria  
Part of EPAM Automation Final Task  
