package dao;

import models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // --- LOGIN METHOD ---
    public User login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            // If a match is found, create the User object and hand it to Person C
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }
        } catch (SQLException e) {
            System.err.println("Login error: " + e.getMessage());
        }
        return null; // Return null if login fails
    }

    // --- REGISTER METHOD ---
    public boolean register(User user) {
        String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)"; // No id (Auto Increment)

        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getRole());

            pstmt.executeUpdate();
            return true; // Registration successful

        } catch (SQLException e) {
            System.err.println("Registration error: " + e.getMessage());
            return false;
        }
    }
}