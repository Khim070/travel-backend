# Travel Backend

This is the backend service for the Travel & Tour Management System Application, built using Java Spring Boot. The backend provides RESTful APIs to manage travel-related data and services. Your required to create a table and column according to the instruction.pdf document

## Table of Contents
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Running the Application](#running-the-application)
- [License](#license)

## Project Structure
- `src/main/java`: Contains the main application code.
- `src/main/resources`: Contains configuration files and static resources.

travel-backend/
├── idea/
├── mvn/
├── image/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example.travelbackend/
│   │   │           ├── api/
│   │   │           │   ├── controller/
│   │   │           │   │   ├── MenuBarController.java
│   │   │           │   │   └── OtherController.java
│   │   │           │   ├── model/
│   │   │           │   │   ├── MenuBar.java
│   │   │           │   │   └── OtherModal.java
│   │   │           ├── configuration/
│   │   │           │   ├── CorsConfig.java
│   │   │           │   ├── SecurityConfig.java
│   │   │           │   └── Webconfig.java
│   │   │           ├── Dao/
│   │   │           │   ├── MenuBarDao
│   │   │           │   │   ├── MenuBarDao.java
│   │   │           │   │   └── MenuBarDaoImplementation.java
│   │   │           │   └── OtherDao
│   │   │           │   │   ├── OtherDao.java
│   │   │           │   │   └── OtherDaoImplementation.java
│   │   │           ├── Services/
│   │   │           │   ├── MenuBarService
│   │   │           │   │   ├── MenuBarService.java
│   │   │           │   │   └── MenuBarServiceImplementation.java
│   │   │           │   └── OtherService
│   │   │           │   │   ├── OtherService.java
│   │   │           │   │   └── OtherServiceImplementation.java
│   │   │           └── TravelBackendApplication.java
│   │   ├── resources/
│   │   │   ├── static
│   │   │   ├── templates
│   │   │   └── application.properties
│   ├── test/
│   │   └── java/
│   │       └── com/
│   │           └── yourpackage/
│   │               └── TravelBackendApplicationTests.java
├── target/
├── .gitignore
├── README.md
├── mvnw
├── mvnw.cmd
└── pom.xml

## Prerequisites
- Java Development Kit (JDK) 8 or later
- Maven
- An IDE like IntelliJ IDEA

## Getting Started

### Cloning the Repository
Clone the repository to your local machine using the following command:
`bash
git clone https://github.com/Khim070/travel-backend.git`

## Setting Up the Project
1. Open the Project: Open the travel-backend project in IntelliJ IDEA.

## Running the Application
1. Start the Spring Boot Application: Run the application from IntelliJ IDEA by locating the main class containing the `main` method annotated with `@SpringBootApplication` and clicking the green run button.

## License
This project is licensed under LEANG Vakhim License
