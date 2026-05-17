package controllers;

import app.MainApp;
import dao.PropertyDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Property;
import models.User;

public class AddEditPropertyController {

    @FXML private Label screenTitleLabel;
    @FXML private Label headerLabel;
    @FXML private TextField nameField;
    @FXML private TextField addressField;
    @FXML private TextArea descriptionArea;
    @FXML private Label errorLabel;
    @FXML private Button submitButton;

    private final PropertyDAO propertyDAO = new PropertyDAO();
    private Property propertyToEdit = null;

    // Called by ManageListingsController when editing an existing property
    public void setProperty(Property property) {
        this.propertyToEdit = property;
        screenTitleLabel.setText("Edit Property");
        headerLabel.setText("Edit Property");
        submitButton.setText("Save Changes");
        nameField.setText(property.getName());
        addressField.setText(property.getAddress());
        descriptionArea.setText(property.getDescription());
    }

    @FXML
    public void handleSubmit() {
        String name = nameField.getText().trim();
        String address = addressField.getText().trim();
        String description = descriptionArea.getText().trim();

        if (name.isEmpty() || address.isEmpty()) {
            errorLabel.setText("Property name and address are required.");
            return;
        }

        if (propertyToEdit == null) {
            // ADD mode
            User user = SessionManager.getInstance().getCurrentUser();
            Property newProperty = new Property(user.getId(), name, address, description);
            boolean success = propertyDAO.addProperty(newProperty);
            if (!success) {
                errorLabel.setText("Failed to add property. Please try again.");
                return;
            }
        } else {
            // EDIT mode
            propertyToEdit.setName(name);
            propertyToEdit.setAddress(address);
            propertyToEdit.setDescription(description);
            boolean success = propertyDAO.updateProperty(propertyToEdit);
            if (!success) {
                errorLabel.setText("Failed to update property. Please try again.");
                return;
            }
        }

        MainApp.switchTo("views/ManageListings.fxml");
    }

    @FXML
    public void handleCancel() {
        MainApp.switchTo("views/ManageListings.fxml");
    }
}