package kilometersconverter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DistanceConverterApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Distance Converter");

        // Create UI controls
        TextField milesField = new TextField();
        TextField kilometersField = new TextField();
        Button convertToKmButton = new Button("Convert to Kilometers");
        Button convertToMilesButton = new Button("Convert to Miles");

        // Set up event handlers
        convertToKmButton.setOnAction(e -> {
            double miles = Double.parseDouble(milesField.getText());
            double kilometers = convertMilesToKilometers(miles);
            kilometersField.setText(String.format("%.2f", kilometers));
        });

        convertToMilesButton.setOnAction(e -> {
            double kilometers = Double.parseDouble(kilometersField.getText());
            double miles = convertKilometersToMiles(kilometers);
            milesField.setText(String.format("%.2f", miles));
        });

        // Create layout
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.add(new Label("Miles:"), 0, 0);
        gridPane.add(milesField, 1, 0);
        gridPane.add(convertToKmButton, 2, 0);
        gridPane.add(new Label("Kilometers:"), 0, 1);
        gridPane.add(kilometersField, 1, 1);
        gridPane.add(convertToMilesButton, 2, 1);

        // Create scene and show stage
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private double convertMilesToKilometers(double miles) {
        return miles * 1.60934;
    }

    private double convertKilometersToMiles(double kilometers) {
        return kilometers * 0.621371;
    }
}
