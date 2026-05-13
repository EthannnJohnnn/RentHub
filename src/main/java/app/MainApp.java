package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Renta application entry point.
 * Day 1 goal: window opens. Nothing else matters yet.
 */
public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("Renta");
        title.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");

        Label status = new Label("Not logged in");

        Button loginBtn = new Button("Login (placeholder)");
        loginBtn.setOnAction(e -> status.setText("Login coming soon..."));

        VBox root = new VBox(20, title, loginBtn, status);
        root.setStyle("-fx-alignment: center; -fx-padding: 40px;");

        Scene scene = new Scene(root, 800, 500);

        stage.setTitle("Renta");
        stage.setScene(scene);
        stage.setMinWidth(600);
        stage.setMinHeight(400);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}