package passwordprotector;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PasswordProtectorApp extends Application {

    private static final String CORRECT_PASSWORD = "password123";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Password Protector");

        // Create UI controls
        PasswordField passwordField = new PasswordField();
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> validatePassword(passwordField.getText()));

        // Create layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(passwordField, submitButton);

        // Create scene and show stage
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void validatePassword(String password) {
        if (password.equals(CORRECT_PASSWORD)) {
            showSuccessAlert("Access Granted");
            // Perform actions for successful password entry
        } else {
            showErrorAlert("Access Denied");
            // Perform actions for incorrect password entry
        }
    }

    private void showSuccessAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
