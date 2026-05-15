package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("Renta");
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);

        switchTo("views/Login.fxml");
        primaryStage.show();
    }

    public static void switchTo(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    MainApp.class.getResource("/" + fxmlPath)
            );
            Parent root = loader.load();
            Scene scene = new Scene(root, 800, 600);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            System.err.println("Could not load: " + fxmlPath);
            e.printStackTrace();
        }
    }

    public static Stage getStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}