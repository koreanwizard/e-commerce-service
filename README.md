# E-Commerce Backend System

This project is a backend application for an e-commerce platform. It's implemented by following frameworks: Java Spring Boot, MySQL, and Thymeleaf. 
It provides essential features for user management, product handling, and order processing for an online store.

## Features

- User Registration and Management: CRUD operations are implemented for user management. Spring Security will be added in the future for user authentication.
- Product Management: CRUD operations will be added to manage products.
- Shopping Cart: This feature will be added in the future.
- Order Management and Cancellation: Order management and cancellation functionality will be added in the future.
- Payment Handling: Payment processing functionality will be added in the future.

## Technologies Used

- **Java Spring Boot**: Framework for creating the backend services.
- **MySQL**: Database to store user, product, and order data. 
- **Thymeleaf**: Template engine for server-side rendering.
- **Gradle**: Dependency management and build tool.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/koreanwizard/e-commerce-service.git

## Configuration

The default Spring Boot configuration file (`application.properties`) includes a reference to the `application-mysql.properties` file using Spring Profiles. This allows for better separation of concerns, especially for the database configuration.

In the `application.properties` file, the following line is included to load the MySQL-specific configurations: spring.profiles.include=mysql

Before running the application, make sure to configure your MySQL database connection by editing the `application-mysql.properties` file.

Example of `application-mysql.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
