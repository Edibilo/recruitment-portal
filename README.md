# Mashad – Job Recruitment Management System

## Overview

Mashad is a web-based Job Recruitment Management System developed using Spring Boot and Thymeleaf. The application simplifies the recruitment process by allowing recruiters to publish job opportunities, applicants to apply for available positions, and administrators to manage users and system roles.

The system provides role-based access control to ensure that users can only access features permitted by their assigned roles.

## Technologies Used

* **Java** – Backend programming language.
* **Spring Boot** – Backend application framework.
* **Spring MVC** – Handles HTTP requests and application routing.
* **Spring Data JPA** – Database operations and persistence.
* **Spring Security** – Authentication and authorization.
* **Thymeleaf** – Server-side HTML rendering.
* **MySQL** – Relational database.
* **Maven** – Dependency management and project build.

## System Features

### 1. Authentication and User Management

* User registration and login.
* Secure password encryption using BCrypt.
* User profile management.
* Update user information.
* Administrator can view, edit, and delete users.

### 2. Role Management

* Create and manage system roles.
* Assign roles to users.
* Restrict access based on user permissions.

### 3. Job Management

* Create new job opportunities.
* View available jobs.
* Update job information.
* Delete job opportunities.
* View applications submitted for specific jobs.

### 4. Application Management

* Applicants can apply for available jobs.
* Recruiters can view applications for their job opportunities.
* Update application statuses.
* Track application progress.

### 5. Applicant Scoring

* Recruiters can evaluate applicants.
* Record applicant scores.
* View applicant scores associated with specific jobs.
* Applicants can view their application scores.

### 6. Dashboard

* Dashboard for monitoring recruitment activities.
* Display application information.
* View applicant-related scores.

## Role-Based Access Control

The application supports three main roles:

| Role      | Permissions                                                                   |
| --------- | ----------------------------------------------------------------------------- |
| ADMIN     | Manage users, roles, and access authorized system features.                   |
| RECRUITER | Manage job opportunities, review applications, and evaluate applicants.       |
| APPLICANT | Browse available jobs, submit applications, and view application information. |

Spring Security manages authentication and authorization using role-based access restrictions.

## Application Routes

| Method | Endpoint                                     | Description                    |
| ------ | -------------------------------------------- | ------------------------------ |
| GET    | `/api/v1/auth/register`                      | Display registration page      |
| POST   | `/api/v1/auth/register`                      | Register a user                |
| GET    | `/api/v1/auth/login`                         | Display login page             |
| GET    | `/api/v1/users/profile`                      | View user profile              |
| GET    | `/api/v1/users/profile/edit`                 | Edit logged-in user profile    |
| GET    | `/api/v1/users`                              | View all users                 |
| GET    | `/api/v1/roles`                              | View system roles              |
| POST   | `/api/v1/roles`                              | Create a role                  |
| GET    | `/api/v1/jobs`                               | View available jobs            |
| POST   | `/api/v1/jobs`                               | Create a job                   |
| GET    | `/api/v1/jobs/{jobId}/edit`                  | Edit a job                     |
| GET    | `/api/v1/jobs/{jobId}/delete`                | Delete a job                   |
| GET    | `/api/v1/jobs/{jobId}/apply`                 | Display job application form   |
| POST   | `/api/v1/jobs/{jobId}/apply`                 | Submit a job application       |
| GET    | `/api/v1/jobs/{jobId}/applications`          | View job applications          |
| GET    | `/api/v1/jobs/{jobId}/score`                 | View applicant scores          |
| GET    | `/api/v1/applications/{applicationId}/score` | Display applicant scoring form |
| POST   | `/api/v1/applications/{applicationId}/score` | Save applicant score           |
| GET    | `/api/v1/dashboards`                         | View dashboard                 |

## Database Configuration

The application uses MySQL as its relational database.

Configure your database connection in `application.properties`:

```properties
spring.application.name=mashad

spring.datasource.url=jdbc:mysql://localhost:3307/mashad
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Make sure MySQL is running and the `mashad` database is available.

## Getting Started

### Prerequisites

Before running the application, ensure you have installed:

* Java JDK 21 or later.
* Maven.
* MySQL Server.
* IntelliJ IDEA or another Java IDE.

### Installation

**1. Clone the repository**

```bash
git clone https://github.com/Edibilo/Mashad.git
```

**2. Navigate to the project directory**

```bash
cd Mashad
```

**3. Configure the database**

Create a MySQL database:

```sql
CREATE DATABASE mashad;
```

Update your database credentials in `application.properties`.

**4. Run the application**

Using Maven:

```bash
mvn spring-boot:run
```

Alternatively, run the main Spring Boot application class from your IDE.

**5. Access the application**

Open your browser:

```text
http://localhost:8080
```

Navigate to the login or registration page:

```text
http://localhost:8080/api/v1/auth/login
```

## Security

The application implements Spring Security with:

* BCrypt password hashing.
* Role-based authorization.
* Protected application, job, user, and role management endpoints.
* Session invalidation during logout.
* Authentication-required profile and dashboard access.

## Project Purpose

Mashad was developed as a practical software development project to demonstrate backend development using the Spring Boot ecosystem.

The project demonstrates the implementation of MVC architecture, database integration, authentication, authorization, CRUD operations, and recruitment workflow management.

## Author

**Edibilo**

GitHub: https://github.com/Edibilo
