package controllers;

import app.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BookingRequestsController {

    @FXML private TableView bookingsTable;
    @FXML private TableColumn tenantColumn;
    @FXML private TableColumn propertyColumn;
    @FXML private TableColumn roomColumn;
    @FXML private TableColumn dateColumn;
    @FXML private TableColumn statusColumn;
    @FXML private TableColumn actionsColumn;
    @FXML private Label requestCountLabel;
    @FXML private Label messageLabel;

    @FXML
    public void initialize() {}

    @FXML
    public void handleBackToDashboard() {
        MainApp.switchTo("views/LandlordDashboard.fxml");
    }

    @FXML
    public void handleLogout() {
        SessionManager.getInstance().logout();
        MainApp.switchTo("views/Login.fxml");
    }
}
