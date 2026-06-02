# ConfigGuard

![Java CI](https://github.com/preranabojja/ConfigGuard/actions/workflows/ci.yml/badge.svg)
# ConfigGuard 

### Enterprise-Grade Java CLI for Automated Configuration Validation, Batch Processing, Reporting, Testing & CI/CD

ConfigGuard is a production-inspired Java command-line application that automates the validation of JSON configuration files through rule-based analysis, batch processing, automated reporting, and continuous integration workflows.

Built using modern software engineering practices including Object-Oriented Design, Maven, JUnit Testing, GitHub Actions CI/CD, Dependency Management, and Executable JAR Packaging.

---

## Key Features

✅ JSON Configuration Parsing (Jackson)

✅ Rule-Based Validation Engine

✅ Batch Validation Across Multiple Configuration Files

✅ Automated TXT Report Generation

✅ Command-Line Interface (CLI)

✅ JUnit 5 Automated Testing

✅ Maven Build & Dependency Management

✅ GitHub Actions Continuous Integration (CI/CD)

✅ Executable Fat JAR Distribution

✅ Extensible Architecture Following SOLID Design Principles

---

## Tech Stack

| Category        | Technology             |
| --------------- | ---------------------- |
| Language        | Java 17                |
| Build Tool      | Maven                  |
| Testing         | JUnit 5                |
| JSON Processing | Jackson                |
| CI/CD           | GitHub Actions         |
| Version Control | Git & GitHub           |
| Architecture    | Object-Oriented Design |

---

## Project Architecture

```text
src/main/java/com/configguard
│
├── model
│   └── Config.java
│
├── parser
│   └── ConfigParser.java
│
├── validator
│   ├── ConfigValidator.java
│   └── ValidationResult.java
│
├── report
│   └── ReportGenerator.java
│
├── service
│   └── BatchValidator.java
│
└── Main.java
```

---

## Validation Rules

ConfigGuard currently performs automated validation checks including:

* Empty server detection
* Invalid port range detection
* Suspicious timeout values
* Port-specific warnings
* Configuration quality auditing

The validation framework is designed to be easily extended with additional enterprise-grade rules.

---

## Installation

Clone the repository:

```bash
git clone https://github.com/preranabojja/ConfigGuard.git
cd ConfigGuard
```

Build the project:

```bash
mvn clean package
```

---

## Usage

### Display Configuration Summary

```bash
java -jar target/configguard-1.0-SNAPSHOT.jar summary configs/dev.json
```

Example:

```text
CONFIG SUMMARY
--------------
Server: localhost
Port: 8080
Timeout: 30
```

---

### Validate a Configuration File

```bash
java -jar target/configguard-1.0-SNAPSHOT.jar validate configs/prod.json
```

Example:

```text
VALIDATION REPORT
-----------------
Valid: false

Errors:
Server cannot be empty
Port must be between 1 and 65535

Warnings:
Timeout is unusually low
```

---

### Batch Validation

Validate all configuration files in a directory:

```bash
java -jar target/configguard-1.0-SNAPSHOT.jar validate-all configs
```

Example:

```text
BATCH VALIDATION
----------------
dev.json             PASS
prod.json            FAIL
sample.json          PASS
```

---

## Software Engineering Highlights

* Designed using Object-Oriented Programming principles
* Implemented modular architecture with separation of concerns
* Automated testing using JUnit 5
* Continuous Integration pipeline with GitHub Actions
* Packaged as a standalone executable JAR using Maven Shade Plugin
* Supports scalable batch-processing workflows

---

## Future Enhancements

* HTML report generation
* CSV export functionality
* Configuration diff engine
* Schema validation support
* Docker containerization
* Cloud-native deployment support

---

## Why This Project?

Configuration errors are one of the most common causes of software deployment failures. ConfigGuard demonstrates how automated validation tooling can improve software quality, reduce operational risk, and streamline configuration management workflows.

---

## Author

**Prerana Bojja**

Computer Science Student | Software Engineering | Data Analytics | Full-Stack Development

GitHub: https://github.com/preranabojja

