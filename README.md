# Medical Appointment Management System

A web application for managing medical appointments, patients, doctors, and appointment slots. Built with Spring Boot and Thymeleaf, the application uses a server-side rendering approach to provide a web interface for managing medical appointment data.

## Overview

This project is a Java web application designed to simplify the management of medical appointments. It organizes the main entities involved in the appointment process: patients, doctors, appointment slots, and appointments.

The application follows a layered architecture that separates HTTP request handling, business logic, and data access.

## Features

- **Patient Management:** Create, view, edit, and list patient records.
- **Doctor Management:** Create, view, edit, and list doctor records.
- **Appointment Slot Management:** Create, view, edit, and list appointment slots.
- **Appointment Management:** Create, view, edit, and list medical appointments.
- **Server-Side Rendering:** Generate HTML pages using Thymeleaf templates.
- **Layered Architecture:** Separate controllers, services, models, and repositories.

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 22 | Programming language |
| Spring Boot 3.3.0 | Application framework |
| Spring MVC | Web request handling |
| Spring Data JPA | Persistence and database access |
| Spring Data JDBC | JDBC-based data access support |
| Thymeleaf | Server-side HTML rendering |
| MySQL | Relational database |
| Maven | Dependency management and build automation |
| Bootstrap | Styling and responsive interface components |
| jQuery | JavaScript utility library |

## Architecture

The application uses a layered architecture:

```text
                  Web Browser
                       |
                       | HTTP Requests
                       v
              Spring MVC Controllers
                       |
                       v
                    Services
                       |
                       v
                  Repositories
                       |
                       v
                    Database

              Controllers
                   |
                   v
           Thymeleaf Templates
                   |
                   v
             HTML Responses
```

### Main Layers

- **Controllers:** Handle incoming HTTP requests and coordinate application operations.
- **Services:** Encapsulate business logic and coordinate data operations.
- **Models:** Represent the main domain entities, including patients, doctors, appointment slots, and appointments.
- **Repositories:** Provide data access and persistence operations.
- **Thymeleaf Templates:** Render the HTML pages returned to the browser.
- **Static Resources:** Contain CSS and JavaScript libraries used by the interface.

## Project Structure

```text
rdvpt/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── johary/
│       │           └── rdvpt/
│       │               ├── RdvptApplication.java
│       │               ├── controllers/
│       │               │   ├── CreneauController.java
│       │               │   ├── MedecinController.java
│       │               │   ├── PatientController.java
│       │               │   └── RvController.java
│       │               ├── models/
│       │               │   ├── Creneaux.java
│       │               │   ├── Medecin.java
│       │               │   ├── Patient.java
│       │               │   └── Rv.java
│       │               ├── repositories/
│       │               │   ├── CreneauRepository.java
│       │               │   ├── MedecinRepository.java
│       │               │   ├── PatientRepository.java
│       │               │   └── RvRepository.java
│       │               └── services/
│       │                   ├── CreneauService.java
│       │                   ├── MedecinService.java
│       │                   ├── PatientService.java
│       │                   └── RvService.java
│       └── resources/
│           ├── application.properties
│           ├── static/
│           │   ├── css/
│           │   │   └── bootstrap.min.css
│           │   └── js/
│           │       ├── bootstrap.min.js
│           │       ├── jquery.min.js
│           │       └── popper.min.js
│           └── templates/
│               ├── creneaux/
│               │   ├── create.html
│               │   ├── detail.html
│               │   ├── edit.html
│               │   └── list.html
│               ├── medecins/
│               │   ├── create.html
│               │   ├── detail.html
│               │   ├── edit.html
│               │   └── list.html
│               ├── patients/
│               │   ├── create.html
│               │   ├── detail.html
│               │   ├── edit.html
│               │   └── list.html
│               └── rdv/
│                   ├── create.html
│                   ├── detail.html
│                   ├── edit.html
│                   └── list.html
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites

Before running the application, make sure you have installed:

- Java Development Kit (JDK) 22
- Apache Maven, or use the Maven Wrapper if it is included in the repository
- MySQL Server
- Git

### 1. Clone the Repository

```bash
git clone https://github.com/JoharyJonathan/Gestion-RDV-Spring.git
cd Gestion-RDV-Spring
```

### 2. Configure the Database

Create a MySQL database for the application. For example:

```sql
CREATE DATABASE gestion_rdv;
```

Configure the database connection in `src/main/resources/application.properties` using your local MySQL credentials.

A typical configuration looks like this:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gestion_rdv
spring.datasource.username=YOUR_DATABASE_USERNAME
spring.datasource.password=YOUR_DATABASE_PASSWORD
```

Adapt these settings to match your actual database name, credentials, and existing application configuration. Do not commit real passwords or other secrets to version control.

### 3. Run the Application

From the project root, run:

```bash
mvn spring-boot:run
```

Alternatively, build the application and run the generated JAR:

```bash
mvn clean package
java -jar target/rdvpt-0.0.1-SNAPSHOT.jar
```

The JAR filename may differ depending on the configuration in `pom.xml`.

Open the application in your browser using the configured server port. If no custom port is configured, Spring Boot uses `8080` by default.

## Web Interface

The application uses Thymeleaf templates rather than a separate JavaScript frontend framework.

Each main resource has a dedicated set of pages:

| Resource | Template directory |
|---|---|
| Appointment slots | `templates/creneaux/` |
| Doctors | `templates/medecins/` |
| Patients | `templates/patients/` |
| Appointments | `templates/rdv/` |

The templates provide pages for creating, viewing, editing, and listing records.

## Build and Testing

Build the project and run the available automated tests with:

```bash
mvn clean verify
```

To run tests without packaging the application:

```bash
mvn test
```

These commands execute the tests configured in the Maven project. The actual test coverage depends on the tests currently included in the repository.

## Learning Objectives

This project provides practical experience with:

- Building Java web applications using Spring Boot.
- Implementing the MVC pattern with Spring MVC and Thymeleaf.
- Separating controllers, services, and repositories.
- Integrating a relational database into a Spring application.
- Organizing server-rendered HTML templates and static resources.
- Managing dependencies and application builds with Maven.

## Possible Improvements

Potential future enhancements include:

- Form validation and clearer error messages.
- Search, filtering, and pagination for patients, doctors, and appointments.
- Appointment conflict detection and availability validation.
- Authentication and role-based access control, if required.
- Automated unit and integration tests.
- Docker-based deployment and continuous integration.
- Improved accessibility and responsive design.

These are potential enhancements, not claims about features already implemented.

## License

No license has been specified in this README. Add a license file if you intend to distribute the project under an open-source license.

## Author

**Johary Jonathan**

GitHub: [JoharyJonathan](https://github.com/JoharyJonathan)