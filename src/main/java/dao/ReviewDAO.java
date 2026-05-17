package dao;

import models.Review;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {

    // CREATE: Add a new review
    public boolean addReview(Review review) {
        String sql = "INSERT INTO reviews (property_id, tenant_id, rating, comment) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, review.getPropertyId());
            pstmt.setInt(2, review.getTenantId());
            pstmt.setInt(3, review.getRating());
            pstmt.setString(4, review.getComment());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error adding review: " + e.getMessage());
            return false;
        }
    }

    // READ: Get all reviews for a specific property
    public List<Review> getReviewsByPropertyId(int propertyId) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews WHERE property_id = ?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, propertyId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    reviews.add(extractReviewFromResultSet(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching reviews: " + e.getMessage());
        }
        return reviews;
    }

    // HELPER: Convert SQL row to Java Object
    private Review extractReviewFromResultSet(ResultSet rs) throws SQLException {
        Review review = new Review();
        review.setId(rs.getInt("id"));
        review.setPropertyId(rs.getInt("property_id"));
        review.setTenantId(rs.getInt("tenant_id"));
        review.setRating(rs.getInt("rating"));
        review.setComment(rs.getString("comment"));
        return review;
    }
}