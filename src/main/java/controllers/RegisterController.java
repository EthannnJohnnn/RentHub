package controllers;

import app.MainApp;
import dao.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.User;

public class RegisterController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private ComboBox<String> roleComboBox;
    @FXML private Label errorLabel;

    private final UserDAO userDAO = new UserDAO();

    @FXML
    public void handleRegister() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        String confirm = confirmPasswordField.getText().trim();
        String role = roleComboBox.getValue();

        if (username.isEmpty() || password.isEmpty() || role == null) {
            errorLabel.setText("Please fill in all fields.");
            return;
        }

        if (!password.equals(confirm)) {
            errorLabel.setText("Passwords do not match.");
            return;
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole(role);

        boolean success = userDAO.register(newUser);

        if (!success) {
            errorLabel.setText("Username already exists.");
            return;
        }

        MainApp.switchTo("views/Login.fxml");
    }

    @FXML
    public void goToLogin() {
        MainApp.switchTo("views/Login.fxml");
    }
}