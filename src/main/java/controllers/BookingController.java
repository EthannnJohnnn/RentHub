package controllers;

import app.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import models.Property;
import models.Room;

public class BookingController {

    @FXML private Label propertyNameLabel;
    @FXML private Label roomNumberLabel;
    @FXML private Label capacityLabel;
    @FXML private Label priceLabel;
    @FXML private DatePicker bookingDatePicker;
    @FXML private Label errorLabel;

    private Room selectedRoom;
    private Property currentProperty;

    public void setRoom(Room room, Property property) {
        this.selectedRoom = room;
        this.currentProperty = property;

        propertyNameLabel.setText(property.getName());
        roomNumberLabel.setText(room.getRoomNumber());
        capacityLabel.setText(room.getCapacity() + " person(s)");
        priceLabel.setText("₱" + String.format("%.2f", room.getPrice()));
    }

    @FXML
    public void handleSubmit() {
        if (bookingDatePicker.getValue() == null) {
            errorLabel.setText("Please select a booking date.");
            return;
        }

        // Booking submission will be wired once BookingDAO is merged from Montejo
        errorLabel.setText("Booking submitted! (Full functionality pending BookingDAO)");
    }

    @FXML
    public void handleCancel() {
        MainApp.switchTo("views/PropertyList.fxml");
    }
}