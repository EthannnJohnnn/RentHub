package controllers;

import app.MainApp;
import dao.BookingDAO;
import dao.RoomDAO;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import models.Booking;
import models.Property;
import models.Room;
import models.User;

public class BookingController {

    @FXML private Label propertyNameLabel;
    @FXML private Label roomNumberLabel;
    @FXML private Label capacityLabel;
    @FXML private Label priceLabel;
    @FXML private DatePicker bookingDatePicker;
    @FXML private Label errorLabel;

    private final BookingDAO bookingDAO = new BookingDAO();
    private final RoomDAO roomDAO = new RoomDAO();
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

        User tenant = SessionManager.getInstance().getCurrentUser();

        Booking booking = new Booking();
        booking.setTenantId(tenant.getId());
        booking.setRoomId(selectedRoom.getId());
        booking.setStatus("PENDING");
        booking.setBookingDate(bookingDatePicker.getValue().toString());

        boolean success = bookingDAO.addBooking(booking);

        if (!success) {
            errorLabel.setText("Failed to submit booking. Please try again.");
            return;
        }

        // Mark room as unavailable
        selectedRoom.setAvailable(false);
        roomDAO.updateRoom(selectedRoom);

        MainApp.switchTo("views/PropertyList.fxml");
    }

    @FXML
    public void handleCancel() {
        MainApp.switchTo("views/PropertyList.fxml");
    }
}