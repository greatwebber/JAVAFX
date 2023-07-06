package percentagecalculator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PercentageCalculatorApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Percentage Calculator");

        // Create UI controls
        TextField numberField = new TextField();
        TextField percentageField = new TextField();
        Button calculateButton = new Button("Calculate");
        Label resultLabel = new Label();

        // Calculate button event handler
        calculateButton.setOnAction(e -> {
            try {
                double number = Double.parseDouble(numberField.getText());
                double percentage = Double.parseDouble(percentageField.getText());
                double result = (number * percentage) / 100.0;
                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
            }
        });

        // Create layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.add(new Label("Number:"), 0, 0);
        gridPane.add(numberField, 1, 0);
        gridPane.add(new Label("Percentage:"), 0, 1);
        gridPane.add(percentageField, 1, 1);
        gridPane.add(calculateButton, 0, 2);
        gridPane.add(resultLabel, 1, 2);

        // Create scene and show stage
        primaryStage.setScene(new Scene(gridPane));
        primaryStage.show();
    }
}
