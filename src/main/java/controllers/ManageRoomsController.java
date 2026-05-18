package controllers;

import app.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import models.Property;

public class ManageRoomsController {

    @FXML private Label navPropertyName;
    @FXML private Label propertyNameLabel;
    @FXML private Label roomCountLabel;
    @FXML private TableView roomsTable;
    @FXML private TableColumn roomNumberColumn;
    @FXML private TableColumn capacityColumn;
    @FXML private TableColumn priceColumn;
    @FXML private TableColumn statusColumn;
    @FXML private TableColumn actionsColumn;
    @FXML private Label messageLabel;
    @FXML private VBox roomFormCard;
    @FXML private Label formTitleLabel;
    @FXML private TextField roomNumberField;
    @FXML private TextField capacityField;
    @FXML private TextField priceField;
    @FXML private CheckBox availableCheckBox;
    @FXML private Label formErrorLabel;
    @FXML private Button formSubmitButton;

    private Property currentProperty;

    public void setProperty(Property property) {
        this.currentProperty = property;
        navPropertyName.setText("Rooms — " + property.getName());
        propertyNameLabel.setText(property.getName() + " — Rooms");
    }

    @FXML
    public void handleAddRoom() {}

    @FXML
    public void handleSubmitRoom() {}

    @FXML
    public void handleCancelForm() {}

    @FXML
    public void handleBack() {
        MainApp.switchTo("views/ManageListings.fxml");
    }

    @FXML
    public void handleLogout() {
        SessionManager.getInstance().logout();
        MainApp.switchTo("views/Login.fxml");
    }
}