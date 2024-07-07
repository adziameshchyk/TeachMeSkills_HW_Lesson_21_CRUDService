# Task:   
	CRUD service via Servlet.   
	Add a user, delete by ID or delete all,   
	Modification of a field for a User with a specific ID.   
	Display all information about the user if requested by ID.   
	Or display all users if the ID is not defined.   
	Do all this via jdbc  
 ---


# CRUD Service

TMS CRUD Service is a web application for user management using a MySQL database. The application provides basic CRUD operations (Create, Read, Update, Delete) for managing user data. It is built in Java using the Java Servlet technology for handling HTTP requests and MySQL Connector for database interaction.

### Key Features

- Add a new user
- Retrieve user information by ID
- Retrieve a list of all users
- Update user data by ID
- Delete a user by ID
- Delete all users

### Technologies

- **Programming Language:** Java
- **Framework:** Jakarta Servlet
- **Database:** MySQL
- **JDBC Driver:** MySQL Connector/J
- **API Testing Tool:** [Postman](https://www.postman.com/)

## Installation and Setup

### 1. Installation

1. **Download the project** from the repository or clone it:

   ```bash
   git clone https://github.com/adziameshchyk/TeachMeSkills_HW_Lesson_21_CRUDService.git
   ```

2. **Import the project** into your IDE (e.g., IntelliJ IDEA or Eclipse).

3. **Ensure you have JDK 11 or later** installed.

4. **Add the dependency** for MySQL Connector to your `pom.xml` file (if using Maven):

   ```xml
   <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>8.0.30</version>
   </dependency>
   ```

   Or add to your `build.gradle` file (if using Gradle):

   ```groovy
   implementation 'mysql:mysql-connector-java:8.0.30'
   ```

5. **Set up the MySQL database**:

   - Create the `user_db` database:

     ```sql
     CREATE DATABASE user_db;
     ```

   - Create the `user` table:

     ```sql
     CREATE TABLE user (
         id INT AUTO_INCREMENT PRIMARY KEY,
         name VARCHAR(50) NOT NULL,
         surname VARCHAR(50),
         age INT NOT NULL,
         email VARCHAR(100)
     );
     ```

6. **Configure the `app.properties` file**:

   Specify the database connection parameters in the `app.properties` file:

   ```properties
   db.url=jdbc:mysql://localhost:3306/user_db
   db.user=root
   db.password=yourpassword
   ```

   Update the path in the `MySQLConnector` class to the location of the `app.properties` file.

### 2 Running the Application

1. **Start your application server** (e.g., Apache Tomcat or Jetty).

2. **Deploy the WAR file** to the application server or use the embedded server in your IDE.

3. **Open your browser** and navigate to:

   ```bash
   http://localhost:8080/users
   ```

## 3. User Guide

The application uses HTTP methods and endpoints for CRUD operations:

#### Endpoints

* `POST /users` - Add a new user
* `GET /users?id={id}` - Get user by ID
* `GET /users` - Get all users
* `PUT /users` - Update user data
* `DELETE /users?id={id}` - Delete user by ID
* `DELETE /users` - Delete all users

#### Request Parameters

* **POST**
    * `name` (required) - User name
    * `surname` (optional) - User surname
    * `age` (required) - User age
    * `email` (optional) - User email
* **PUT**
    * `id` (required) - User ID
    * Same parameters as POST (optional)

#### Request Examples

**Add a User:**

```http
POST /users
name=Elon&surname=Musk&age=53&email=e.musk@email.com
```
![image](https://github.com/adziameshchyk/TeachMeSkills_HW_Lesson_21_CRUDService/assets/123600438/424b28ba-d159-4b93-9f3e-2f69c234ca6c)  

![image](https://github.com/adziameshchyk/TeachMeSkills_HW_Lesson_21_CRUDService/assets/123600438/5993a0e5-7f77-4c0c-8fae-30408d8929be)

**Get User by ID:**

```http
GET /users?id=55
```
![image](https://github.com/adziameshchyk/TeachMeSkills_HW_Lesson_21_CRUDService/assets/123600438/ab9114fa-0ca5-4c0a-b9be-0dd8ed3e4494)

**Get All Users:**

```http
GET /users
```
![image](https://github.com/adziameshchyk/TeachMeSkills_HW_Lesson_21_CRUDService/assets/123600438/5f56d563-8013-4a57-87cb-5483666a108b)

**Update User Data:**

```http
PUT /users
id=55&name=Elon&surname=Musk&age=54&email=elon.musk@email.com
```
![image](https://github.com/adziameshchyk/TeachMeSkills_HW_Lesson_21_CRUDService/assets/123600438/855c1a48-1ede-4779-a123-c540e5372e02)  

![image](https://github.com/adziameshchyk/TeachMeSkills_HW_Lesson_21_CRUDService/assets/123600438/c9bda029-5c00-4595-9bf4-e245d81489b0)

**Delete User by ID:**

```http
DELETE /users?id=55
```
![image](https://github.com/adziameshchyk/TeachMeSkills_HW_Lesson_21_CRUDService/assets/123600438/b313a824-ec1b-4f54-80d3-9d463ddcdf40)  

![image](https://github.com/adziameshchyk/TeachMeSkills_HW_Lesson_21_CRUDService/assets/123600438/3fe80cef-0994-46d8-a079-ff0a287adb63)


**Delete All Users:**

```http
DELETE /users
```
![image](https://github.com/adziameshchyk/TeachMeSkills_HW_Lesson_21_CRUDService/assets/123600438/7f8ab150-d6e6-48bd-a722-5a6e50a8be1e)  

![image](https://github.com/adziameshchyk/TeachMeSkills_HW_Lesson_21_CRUDService/assets/123600438/6c89eeb9-194e-4869-9c48-eae18ccfd65c)


## Project Structure

The project is organized into several packages:

* `com.tms.connector`: Contains the `MySQLConnector` class for managing and setting up the database connection.
* `com.tms.model`: Contains the `User` class representing user data.
* `com.tms.service`: Contains the `UserCRUDService` and `UserService` classes for implementing CRUD operations and business logic.
* `com.tms.servlet`: Contains the `UserServlet` class responsible for handling HTTP requests and responses.



  
