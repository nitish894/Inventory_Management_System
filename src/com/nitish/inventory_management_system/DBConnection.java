
package com.nitish.inventory_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String url =
            "jdbc:mysql://localhost:3306/inventory_db";
    private static final String USER = "root";
    private static final String password = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, USER, password);
    }

    public static void main(String[] args) {
        try (Connection con = getConnection()) {
            System.out.println("Database connected successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
