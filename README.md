# 🎓 Student Management System

A full-stack web application built to manage student records, track daily attendance, and publish grades. It features a secure, role-based backend powered by **Spring Boot** and **Spring Security**, and a modern, responsive **Glassmorphism** frontend built with HTML, CSS, and Vanilla JavaScript.

## 🚀 Technologies Used
* **Backend:** Java, Spring Boot, Spring Security, Spring Data JPA
* **Database:** MySQL
* **Frontend:** HTML5, CSS3 (Custom Glassmorphism UI), Vanilla JS, Bootstrap 5 Modals
* **Security:** BCrypt Password Hashing, Basic Authentication, Role-Based Access Control (Admin vs. Student)

---

## 🛠️ How to Run This Project Locally

### 1. Prerequisites
Before you begin, ensure you have the following installed on your machine:
* [Java Development Kit (JDK) 17 or higher](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [MySQL Server](https://dev.mysql.com/downloads/installer/) & MySQL Workbench
* [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) (or any preferred Java IDE)

### 2. Database Setup
1. Open **MySQL Workbench**.
2. Create a new database for the project by running this SQL command:
   ```sql
   CREATE DATABASE studentsystem;
   ```

### 3. Download and Open the Project
1. Click the green **Code** button at the top of this repository and select **Download ZIP**.
2. Extract the downloaded ZIP file to your preferred location.
3. Open **IntelliJ IDEA**, click **File > Open**, and select the extracted folder.
4. Wait a few moments for Maven to download the required dependencies.

### 4. Configure Application Properties
1. Navigate to `src/main/resources/application.properties`.
2. Update the database credentials to match your local MySQL setup:
   ```properties
   spring.datasource.username=root
   spring.datasource.password=YOUR_MYSQL_PASSWORD
   ```

### 5. Start the Server
1. In IntelliJ, locate the main application file: `src/main/java/com/example/studentsystem/StudentSystemApplication.java`.
2. Right-click the file and select **Run 'StudentSystemApplication'**.
3. Wait until the terminal displays: `Started StudentSystemApplication`.

---

## 💻 How to Use the Application

Once the server is running, open your web browser and navigate to:
👉 **http://localhost:8080/index.html**

### 👑 Admin Access (Full Control)
The system automatically generates a default Admin account on startup.

| Field    | Value    |
|----------|----------|
| Username | admin    |
| Password | admin123 |

**Admin Capabilities:**
* Add, edit, and delete student profiles.
* Mark daily attendance (Present / Absent).
* Assign exam grades and subjects.
* Change password securely.

### 🎓 Student Access (Read-Only)
New students must create their own accounts:
1. On the login page, click **"Need an account?"**.
2. Fill out the registration form with your details and choose a username and password.
3. Click **Create Account** and log in with your new credentials.

**Student Capabilities:**
* View a personalized dashboard.
* View personal attendance history.
* View personal report card / grades.
* Change password securely.

> **Note:** Students are blocked from editing data or accessing Admin management tools.

---

*Designed and developed by Anusaya Pradhan*