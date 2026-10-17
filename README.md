# Inventory & Stock Management System

A console-based Inventory Management System developed using **Java, JDBC, and MySQL**. This project helps manage product stock through basic CRUD operations.

## Features

- Add new products
- Display all products
- Search products by ID
- Update product details
- Delete products
- Store product information in a MySQL database

## Technologies Used

- Java
- JDBC (Java Database Connectivity)
- MySQL
- IntelliJ IDEA

## Database Setup

1. Install MySQL and start the server.
2. Create the database:

   ```sql
   CREATE DATABASE inventory_db;
   ```

3. Create the `products` table:

   ```sql
   USE inventory_db;

   CREATE TABLE products (
       product_id INT PRIMARY KEY AUTO_INCREMENT,
       product_name VARCHAR(200) NOT NULL,
       product_price DECIMAL(10,2) NOT NULL,
       quantity INT DEFAULT 0
   );
   ```

4. Configure your MySQL connection in `DBConnection.java`.
5. Ensure the MySQL Connector/J driver is added to the project.

## How to Run

1. Clone or download this repository.
2. Open the project in IntelliJ IDEA.
3. Configure the database connection with your own local credentials.
4. Ensure MySQL is running and the database and table have been created.
5. Run the `Main.java` class.

## Learning Objectives

This project demonstrates Java object-oriented programming, JDBC database connectivity, SQL operations, and basic inventory management.

## Author

Nitish Kumar Mahato
