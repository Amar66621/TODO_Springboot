# 📝 Todo List Application

A simple and intuitive Todo List application built using **Spring Boot**, **Spring Data JPA**, **H2/MySQL**, and **Thymeleaf**.

## 📋 Project Overview

This Todo List application allows users to manage their daily tasks effectively. Users can add, edit, delete, and mark tasks as completed, along with setting due dates and timestamps for each task.

## ⚙️ Technologies Used

- **Spring Boot** - Backend framework for building Java applications
- **Spring Data JPA** - Simplifies database interaction
- **H2/MySQL** - Database for storing tasks (H2 for in-memory, or MySQL for production)
- **Postman** - Used for testing API endpoints

## 🚀 Features

- Create new tasks with title, description, due date, and timestamp
- View all tasks with their current status (completed or pending)
- Edit or update existing tasks
- Mark tasks as completed
- Delete tasks when they are no longer needed
- Manage task due dates and view creation timestamps

## 💻 Setup Instructions

To set up the project locally:

1. **Configure MySQL Database**:
   - Create a new database in MySQL:
     ```sql
     CREATE DATABASE todo_app;
     ```

   - Update the `application.properties` file with your MySQL credentials:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/todo_app
     spring.datasource.username=your-username
     spring.datasource.password=your-password
     ```

2. **Run the application**: Use Maven or your IDE to run the Spring Boot project.
   
3. The application will run at `http://localhost:8080`.

## 💾 Database Schema

In your MySQL database, the following table structure will be created automatically upon running the application:

```sql
CREATE TABLE todo_list (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    completed BOOLEAN DEFAULT FALSE,
    due_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## 🌐 Example JSON for Testing (Postman)
```
{
    "title": "Complete Spring Boot Project",
    "description": "Finish the Todo application with timestamps and due date.",
    "completed": false,
    "dueDate": "2024-10-10"
}

