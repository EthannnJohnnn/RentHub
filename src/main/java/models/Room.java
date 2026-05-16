package models;

public class Room {
    private int id;
    private int propertyId;
    private String roomNumber;
    private int capacity;
    private double price;
    private boolean isAvailable;

    public Room() {}

    public Room(int id, int propertyId, String roomNumber, int capacity, double price, boolean isAvailable) {
        this.id = id;
        this.propertyId = propertyId;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public Room(int propertyId, String roomNumber, int capacity, double price, boolean isAvailable) {
        this.propertyId = propertyId;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPropertyId() { return propertyId; }
    public void setPropertyId(int propertyId) { this.propertyId = propertyId; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}