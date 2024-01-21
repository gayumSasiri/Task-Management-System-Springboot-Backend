# Task Management App (Springboot - backend)

Welcome to our Task Management System! This comprehensive application is designed to provide users with a seamless experience in organizing their tasks efficiently. With a robust set of features encompassing Create, Read, Update, and Delete (CRUD) functionalities, our system empowers both regular users and administrators to take control of their task management needs.

## Key Features

### Task Management

- **Create:** Easily add new tasks to your task-management list.
- **Read:** View your tasks at a glance for efficient organization.
- **Update:** Modify task details to keep information up-to-date.
- **Delete:** Remove completed or unnecessary tasks effortlessly.

### User Authentication

- Our system incorporates a secure user authentication system to safeguard user accounts and data.
- Two Distinct Roles: Users are categorized into two roles - "admin" and "regular user," each with specific privileges tailored to their responsibilities.

### Role-Based Access Control

#### Regular Users

- **View and Manage Own Tasks:** Regular users can seamlessly access and manipulate their personal task lists for a personalized and organized experience.

#### Admins

- **Manage All Tasks:** Administrators enjoy extended privileges, enabling them to oversee and control all tasks within the system.

Whether you're an individual striving to stay organized or an administrator overseeing the entire task ecosystem, our Task Management System provides a user-friendly and efficient solution to meet your needs. Dive in and experience the convenience of effective task management!

## How to setup

### Step1: Clone the repository

- ```shell
   https://github.com/gayumSasiri/Task-Management-System-Springboot-Backend.git
  
### Step2: Open the Project

- Open the project in your preferred Integrated Development Environment (IDE), such as IntelliJ IDEA, Eclipse, or Visual Studio Code.

### Step3: Navigate to `application.properties`

- Navigate to the `src/main/resources` directory within your project, and locate the `application.properties` file.
- 
### Step4: Update MySQL Username and Password

- Open the application.properties file in a text editor. Look for the following lines:

- `spring.datasource.username=your_username`
- `spring.datasource.password=your_password`

### Step5: Build and Run the Application

- Build and run the Spring Boot application.

## Tech Stack Used

- **Back End** - springboot
- **Hibernate** - validator & ORM
- **DBMS** - mysql
- **lombok** 
- **Springboot dev tools**
- **Model mapper**

### Version 0.1.0

### License
Copyright &copy; 2023 GAYUM HENDAWITHARANA.All Rights Reserved.<br>
This project is licensed under this [MIT License](LICENSE.txt)