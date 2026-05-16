package models;

public class Review {
    private int id;
    private int propertyId;
    private int tenantId;
    private int rating;
    private String comment;

    public Review() {}

    public Review(int id, int propertyId, int tenantId, int rating, String comment) {
        this.id = id;
        this.propertyId = propertyId;
        this.tenantId = tenantId;
        this.rating = rating;
        this.comment = comment;
    }

    public Review(int propertyId, int tenantId, int rating, String comment) {
        this.propertyId = propertyId;
        this.tenantId = tenantId;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPropertyId() { return propertyId; }
    public void setPropertyId(int propertyId) { this.propertyId = propertyId; }

    public int getTenantId() { return tenantId; }
    public void setTenantId(int tenantId) { this.tenantId = tenantId; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}