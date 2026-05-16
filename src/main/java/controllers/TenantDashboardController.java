package controllers;

import app.MainApp;
import javafx.fxml.FXML;

public class TenantDashboardController {

    @FXML
    public void handleLogout() {
        SessionManager.getInstance().logout();
        MainApp.switchTo("views/Login.fxml");
    }
}