package controllers;

import app.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MyBookingsController {

    @FXML private TableView bookingsTable;
    @FXML private TableColumn propertyColumn;
    @FXML private TableColumn roomColumn;
    @FXML private TableColumn priceColumn;
    @FXML private TableColumn dateColumn;
    @FXML private TableColumn statusColumn;
    @FXML private Label bookingCountLabel;

    @FXML
    public void initialize() {}

    @FXML
    public void handleBackToDashboard() {
        MainApp.switchTo("views/TenantDashboard.fxml");
    }

    @FXML
    public void handleLogout() {
        SessionManager.getInstance().logout();
        MainApp.switchTo("views/Login.fxml");
    }
}
