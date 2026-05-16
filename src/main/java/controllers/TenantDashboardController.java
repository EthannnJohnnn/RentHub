package controllers;

import app.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import models.User;

public class TenantDashboardController {

    @FXML
    public void handleLogout() {
        SessionManager.getInstance().logout();
        MainApp.switchTo("views/Login.fxml");
    }

    @FXML private Label welcomeLabel;

    @FXML
    public void initialize() {
        User user = SessionManager.getInstance().getCurrentUser();
        if (user != null) {
            welcomeLabel.setText("Welcome, " + user.getUsername());
        }
}
}