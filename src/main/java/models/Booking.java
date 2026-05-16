package models;

public class Booking {
    private int id;
    private int tenantId;
    private int roomId;
    private String status; // "PENDING", "APPROVED", or "REJECTED"
    private String bookingDate;

    public Booking() {}

    public Booking(int id, int tenantId, int roomId, String status, String bookingDate) {
        this.id = id;
        this.tenantId = tenantId;
        this.roomId = roomId;
        this.status = status;
        this.bookingDate = bookingDate;
    }

    public Booking(int tenantId, int roomId, String status, String bookingDate) {
        this.tenantId = tenantId;
        this.roomId = roomId;
        this.status = status;
        this.bookingDate = bookingDate;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getTenantId() { return tenantId; }
    public void setTenantId(int tenantId) { this.tenantId = tenantId; }

    public int getRoomId() { return roomId; }
    public void setRoomId(int roomId) { this.roomId = roomId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getBookingDate() { return bookingDate; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }
}