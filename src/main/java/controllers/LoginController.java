package controllers;

import app.MainApp;
import dao.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.User;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    private final UserDAO userDAO = new UserDAO();

    @FXML
    public void handleLogin() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Please fill in all fields.");
            return;
        }

        User user = userDAO.login(username, password);

        if (user == null) {
            errorLabel.setText("Invalid username or password.");
            return;
        }

        SessionManager.getInstance().setCurrentUser(user);

        if ("landlord".equals(user.getRole())) {
            MainApp.switchTo("views/LandlordDashboard.fxml");
        } else {
            MainApp.switchTo("views/TenantDashboard.fxml");
        }
    }

    @FXML
    public void goToRegister() {
        MainApp.switchTo("views/Register.fxml");
    }
}