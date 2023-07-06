package agecalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculatorApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Age Calculator");

        // Create UI controls
        DatePicker birthdatePicker = new DatePicker();
        Button calculateButton = new Button("Calculate");
        Label resultLabel = new Label();

        // Create layout
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        root.add(new Label("Birthdate:"), 0, 0);
        root.add(birthdatePicker, 1, 0);
        root.add(calculateButton, 0, 1);
        root.add(resultLabel, 1, 1);

        // Handle button click event
        calculateButton.setOnAction(e -> {
            LocalDate birthdate = birthdatePicker.getValue();
            if (birthdate != null) {
                LocalDate currentDate = LocalDate.now();
                Period age = Period.between(birthdate, currentDate);
                int years = age.getYears();
                int months = age.getMonths();
                int days = age.getDays();
                resultLabel.setText("Age: " + years + " years, " + months + " months, " + days + " days");
            } else {
                resultLabel.setText("Please select a birthdate");
            }
        });

        // Create scene and show stage
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
