package lengthconverter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LengthConverterApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Length Converter");

        // Create UI controls
        Label titleLabel = new Label("Length Converter");
        Label inputLabel = new Label("Enter Length:");
        TextField inputField = new TextField();
        ComboBox<String> unitComboBox = new ComboBox<>();
        unitComboBox.getItems().addAll("Centimeters", "Meters", "Kilometers", "Inches", "Feet", "Yards");
        Button convertButton = new Button("Convert");
        Label resultLabel = new Label("Converted Length:");
        Label outputLabel = new Label();

        // Set action for the convert button
        convertButton.setOnAction(e -> {
            String inputText = inputField.getText();
            if (!inputText.isEmpty()) {
                double inputValue = Double.parseDouble(inputText);
                String selectedUnit = unitComboBox.getValue();
                double convertedValue = convertLength(inputValue, selectedUnit);
                outputLabel.setText(String.format("%.2f %s", convertedValue, selectedUnit));
            }
        });

        // Create layout and add controls
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.add(titleLabel, 0, 0, 2, 1);
        gridPane.add(inputLabel, 0, 1);
        gridPane.add(inputField, 1, 1);
        gridPane.add(unitComboBox, 0, 2);
        gridPane.add(convertButton, 1, 2);
        gridPane.add(resultLabel, 0, 3);
        gridPane.add(outputLabel, 1, 3);

        // Create scene and show stage
        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private double convertLength(double value, String unit) {
        double convertedValue = 0.0;

        switch (unit) {
            case "Centimeters":
                convertedValue = value;
                break;
            case "Meters":
                convertedValue = value * 100;
                break;
            case "Kilometers":
                convertedValue = value * 100000;
                break;
            case "Inches":
                convertedValue = value * 2.54;
                break;
            case "Feet":
                convertedValue = value * 30.48;
                break;
            case "Yards":
                convertedValue = value * 91.44;
                break;
        }

        return convertedValue;
    }
}
