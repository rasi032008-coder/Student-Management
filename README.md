# Student Management System

> Dynamic student profile and grade management built with Java and Spring Boot.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
<!-- ![License](https://img.shields.io/badge/license-MIT-blue) -->

<!-- ![Demo](screenshots/demo.png) -->


## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [User Roles](#user-roles)
- [Screenshots](#screenshots)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Database Setup](#database-setup)
- [Running the Application](#running-the-application)
- [Default Login Credentials](#default-login-credentials)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Database Design](#database-design)
- [Future Improvements](#future-improvements)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Features

### Common to all
- Sign in

### Management
- Add a student to the database
- Remove a student from the database

### Faculty
- Assign marks
- Check marks
- Get the student list

### Student
- View marks
- Print grades

## Tech Stack

| Layer        | Technology                         |
| ------------ | ---------------------------------- |
| Language     | Java 17                            |
| Framework    | Spring Boot 3.3.5                  |
| Persistence  | Spring Data JPA / Hibernate        |
| Database     | Sqlite (DB file in the repo)       |
| Frontend     | REST only                          |
| Build tool   | Maven                              |

<!-- Delete or change the rows that don't apply to your project -->

## User Roles

| Role       | Permissions                                      |
| ---------- | ------------------------------------------------ |
| Management | Add and remove students                          |
| Faculty    | Assign marks, check marks, get the student list  |
| Student    | View marks, print grades                         |

## Screenshots

| Login Page | Faculty Dashboard | Student Grades |
| ---------- | ----------------- | -------------- |
| ![Login](screenshots/login.png) | ![Faculty](screenshots/faculty.png) | ![Grades](screenshots/grades.png) |

## Prerequisites

Make sure you have these installed:

- JDK 17 or higher
- Maven 3.8 or higher
- Sqlite 3.4 or higher 
- Git

Check your versions:

```bash
java -version
mvn -version
```

## Installation

```bash
# 1. Clone the repository
git clone https://github.com/rasi032008-coder/Student-Management.git

# 2. Go into the project folder
cd Student-Management/StudentManagement

# 3. Build the project
mvn clean install
```

## Database Setup

1. Create a database:

   ```sql
   CREATE DATABASE student.db;
   ```

2. Open `src/main/resources/application.properties` and update it:

   ```properties
   spring.datasource.driver-class-name = org.sqlite.JDBC
   spring.datasource.url=jdbc:sqlite:[/Path_to_DB]

   spring.jpa.database-platform-org.hibernate.community.dialect.SQLiteDialect
   ```



## Running the Application

```bash
mvn spring-boot:run
```
Note : If you are using Intellij then just run the SpringApplication

Then open your browser at:

```
http://localhost:8080
```

## Default Login Credentials

Use these accounts for testing (change them in production):

| Role       | Username           | Password     |
| ---------- | ----------         | ----------   |
| Management | management[No name]| ceg@au123    |
| Faculty    | ProfName           | [name]@au123 |
| Student    | Name               | [Name]@au123 |

## Project Structure

```
StudentManagement/
├── src/
│   ├── main/
│   │   ├── java/com/example/studentmanagement/
│   │   │   ├── controllers/    # Handles web requests
│   │   │   ├── services/       # Business logic
│   │   │   ├── Repository/     # Database access
│   │   │   ├── Model/          # Entity classes
│   │   │   └── config/        
│   │   └── resources/
│   │       ├── templates/     
│   │       └── application.properties
│   └── test/                  
└── pom.xml
└──Grade.txt
└──ValidSignIns.txt
└──InvalidSignIns.txt
```

## API Endpoints



| Method | Endpoint                              | Description              | Role                 |
| ------ | ------------------------------------  | ------------------------ | -----------------    |
| GET    | `/student`                            | Sign in                  | Student              |
| GET    | `/faculty/{str}`                      | Sign in                  | Faculty              |
| GET    | `/managemen/`                         | Sign in                  | Management           |
| POST   | `/management/addstudent`              | Add a student            | Management       | 
| DELETE | `/management/{id}`                    | Remove a student         | Management       |
| GET    | `/faculty/getstudents/{accessCode}`   | Get the student list     | Faculty          |
| PUT    | `/faculty/{courseName}`               | Assign marks             | Faculty          |
| GET    | `/management/grade/{id}`              | Grade sheet              | Faculty, Student |

## Database Design

```mermaid
erDiagram
    passwords  ||--o| management passwords
    student    ||--o{ MARKS : has marks }
    management ||--o{ MARKS : assigns marks }

    management {
        string jfaculty
        string dfaculty
        string sfaculty
        string jpassword
        string spassword
        string dpassword
    }
    student {
        int id
        string name
        string email
        string department
    }
    passwords {
        string mpassword
    }
    
```

## Future Improvements

- [ ] Attendance tracking
- [ ] Email notifications
- [ ] PDF report card download
- [ ] Password reset
- [ ] Search and pagination for the student list



<!-- ## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details. -->

## Contact

Name : [@Micah-Jaden-G-Git](https://github.com/Micah-Jaden-G-Git)
Name: [@rasi032008-coder](https://github.com/rasi032008-coder)
Found a bug or have a suggestion? [Open an issue](https://github.com/rasi032008-coder/Student-Management/issues).
