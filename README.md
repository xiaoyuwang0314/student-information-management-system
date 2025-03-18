# Student Management System

A Java-based student management system built with Spring Boot and Swing GUI.

## Prerequisites

- JDK 17 or later
- MySQL 8.0 or later
- Maven 3.6 or later
- IntelliJ IDEA (recommended)

## Database Setup

1. Install MySQL if you haven't already
2. Create a new database named `student` 

using the following SQL command:
```sql
CREATE DATABASE student;
```
3. Configure database connection:
   - Step 1: Update `src/main/resources/application.properties`:
     ```properties
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```
   - Step 2: Update `src/main/java/StudentManagement/utils/DatabaseUtil.java`:
     ```java
     private static final String USER = "your_username";
     private static final String PASSWORD = "your_password";
     ```


## Features

- Add new students
- Update student information
- Delete students
- View student details
- Real-time input validation
- Database persistence


## Notes

- The system uses MySQL for data persistence
- Default database port is 3306
- The application runs on Spring Boot
- GUI is implemented using Java Swing

## Troubleshooting

If you encounter database connection issues:
1. Verify MySQL is running
2. Check username and password in configuration files (src/main/resources/application.properties and src/main/java/StudentManagement/utils/DatabaseUtil.java)
3. Ensure database `student` exists
4. Verify MySQL port (default: 3306)
5. Open Docker Desktop and check if MySQL container is running
