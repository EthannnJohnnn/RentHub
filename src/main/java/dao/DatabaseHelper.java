package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {

    private static final String DB_URL = "jdbc:sqlite:renta.db";
    private static Connection connection;

    private DatabaseHelper() {} // Private constructor prevents manual instantiation

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL);
            }
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
        }
        return connection;
    }
}