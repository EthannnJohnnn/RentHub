package controllers;

import app.MainApp;
import dao.PropertyDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import models.Property;
import models.User;

import java.util.List;

public class LandlordDashboardController {

    @FXML private Label welcomeLabel;
    @FXML private ListView<String> listingsView;

    private final PropertyDAO propertyDAO = new PropertyDAO();

    @FXML
    public void initialize() {
        User user = SessionManager.getInstance().getCurrentUser();
        if (user != null) {
            welcomeLabel.setText("Welcome, " + user.getUsername());
            loadListings(user.getId());
        }
    }

    private void loadListings(int landlordId) {
        List<Property> properties = propertyDAO.getPropertiesByLandlordId(landlordId);
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Property p : properties) {
            items.add(p.getName() + " — " + p.getAddress());
        }
        listingsView.setItems(items);
    }

    @FXML
    public void handleAddProperty() {
        MainApp.switchTo("views/AddEditProperty.fxml");
    }

    @FXML
    public void handleManageListings() {
        MainApp.switchTo("views/ManageListings.fxml");
    }

    @FXML
    public void handleLogout() {
        SessionManager.getInstance().logout();
        MainApp.switchTo("views/Login.fxml");
    }
}