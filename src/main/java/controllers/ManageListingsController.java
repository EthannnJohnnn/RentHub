package controllers;

import app.MainApp;
import dao.PropertyDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import models.Property;
import models.User;

import java.io.IOException;
import java.util.List;

public class ManageListingsController {

    @FXML private TableView<Property> listingsTable;
    @FXML private TableColumn<Property, String> nameColumn;
    @FXML private TableColumn<Property, String> addressColumn;
    @FXML private TableColumn<Property, String> descriptionColumn;
    @FXML private TableColumn<Property, String> actionsColumn;
    @FXML private Label listingCountLabel;
    @FXML private Label messageLabel;

    private final PropertyDAO propertyDAO = new PropertyDAO();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getName()));
        addressColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getAddress()));
        descriptionColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getDescription()));

        actionsColumn.setCellFactory(col -> new TableCell<>() {
            private final Button editBtn = new Button("Edit");
            private final Button deleteBtn = new Button("Delete");
            private final javafx.scene.layout.HBox box =
                    new javafx.scene.layout.HBox(8, editBtn, deleteBtn);

            {
                editBtn.setStyle("-fx-background-color: #4A9EFF; -fx-text-fill: white; " +
                        "-fx-background-radius: 6; -fx-cursor: hand; -fx-font-size: 12px;");
                deleteBtn.setStyle("-fx-background-color: #EF4444; -fx-text-fill: white; " +
                        "-fx-background-radius: 6; -fx-cursor: hand; -fx-font-size: 12px;");

                editBtn.setOnAction(e -> {
                    Property selected = getTableView().getItems().get(getIndex());
                    navigateToEdit(selected);
                });

                deleteBtn.setOnAction(e -> {
                    Property selected = getTableView().getItems().get(getIndex());
                    handleDelete(selected);
                });
            }

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : box);
            }
        });

        loadListings();
    }

    private void loadListings() {
        User user = SessionManager.getInstance().getCurrentUser();
        List<Property> properties = propertyDAO.getPropertiesByLandlordId(user.getId());
        ObservableList<Property> data = FXCollections.observableArrayList(properties);
        listingsTable.setItems(data);
        listingCountLabel.setText(properties.size() + " properties listed");
    }

    private void navigateToEdit(Property property) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    MainApp.class.getResource("/views/AddEditProperty.fxml"));
            Parent root = loader.load();
            AddEditPropertyController controller = loader.getController();
            controller.setProperty(property);
            MainApp.getStage().setScene(new Scene(root, 800, 600));
        } catch (IOException e) {
            messageLabel.setText("Failed to open edit screen.");
            e.printStackTrace();
        }
    }

    private void handleDelete(Property property) {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Delete Property");
        confirm.setHeaderText("Delete \"" + property.getName() + "\"?");
        confirm.setContentText("This will also delete all rooms under this property. This cannot be undone.");

        confirm.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                boolean success = propertyDAO.deleteProperty(property.getId());
                if (success) {
                    messageLabel.setStyle("-fx-text-fill: #10B981; -fx-font-weight: bold;");
                    messageLabel.setText("Property deleted successfully.");
                    loadListings();
                } else {
                    messageLabel.setText("Failed to delete property.");
                }
            }
        });
    }

    @FXML
    public void handleAddProperty() {
        MainApp.switchTo("views/AddEditProperty.fxml");
    }

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