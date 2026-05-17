package controllers;

import app.MainApp;
import dao.ReviewDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import models.Property;
import models.Review;
import models.User;

import java.util.List;

public class ReviewController {

    @FXML private Label navPropertyName;
    @FXML private Label propertyNameLabel;
    @FXML private Label reviewCountLabel;
    @FXML private ListView<String> reviewListView;
    @FXML private ComboBox<Integer> ratingComboBox;
    @FXML private TextArea commentArea;
    @FXML private Label errorLabel;
    @FXML private Label successLabel;

    private final ReviewDAO reviewDAO = new ReviewDAO();
    private Property currentProperty;

    public void setProperty(Property property) {
        this.currentProperty = property;
        navPropertyName.setText(property.getName());
        propertyNameLabel.setText(property.getName() + " — Reviews");
        ratingComboBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5));
        loadReviews();
    }

    private void loadReviews() {
        List<Review> reviews = reviewDAO.getReviewsByPropertyId(currentProperty.getId());
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Review r : reviews) {
            items.add("⭐ " + r.getRating() + "/5 — " + r.getComment());
        }
        reviewListView.setItems(items);
        reviewCountLabel.setText(reviews.size() + " review(s)");
    }

    @FXML
    public void handleSubmitReview() {
        Integer rating = ratingComboBox.getValue();
        String comment = commentArea.getText().trim();

        if (rating == null) {
            errorLabel.setText("Please select a rating.");
            successLabel.setText("");
            return;
        }

        if (comment.isEmpty()) {
            errorLabel.setText("Please write a comment.");
            successLabel.setText("");
            return;
        }

        User tenant = SessionManager.getInstance().getCurrentUser();

        Review review = new Review();
        review.setPropertyId(currentProperty.getId());
        review.setTenantId(tenant.getId());
        review.setRating(rating);
        review.setComment(comment);

        boolean success = reviewDAO.addReview(review);

        if (!success) {
            errorLabel.setText("Failed to submit review. Please try again.");
            successLabel.setText("");
            return;
        }

        errorLabel.setText("");
        successLabel.setText("Review submitted successfully!");
        commentArea.clear();
        ratingComboBox.setValue(null);
        loadReviews();
    }

    @FXML
    public void handleBack() {
        MainApp.switchTo("views/PropertyList.fxml");
    }
}