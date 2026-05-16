package controllers;

import app.MainApp;
import dao.PropertyDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import models.Property;
import models.User;

import java.util.List;
import java.util.stream.Collectors;

public class TenantDashboardController {

    @FXML private Label welcomeLabel;
    @FXML private ListView<String> propertyListView;
    @FXML private TextField searchField;

    private final PropertyDAO propertyDAO = new PropertyDAO();
    private List<Property> allProperties;

    @FXML
    public void initialize() {
        User user = SessionManager.getInstance().getCurrentUser();
        if (user != null) {
            welcomeLabel.setText("Welcome, " + user.getUsername());
        }

        allProperties = propertyDAO.getAllProperties();
        populateList(allProperties);

        searchField.textProperty().addListener((obs, oldVal, newVal) -> handleSearch(newVal));
    }

    }
}