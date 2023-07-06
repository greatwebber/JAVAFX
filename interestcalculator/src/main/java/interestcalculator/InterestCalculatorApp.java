package interestcalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InterestCalculatorApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Interest Calculator");

        // Create UI controls
        Label principalLabel = new Label("Principal:");
        TextField principalField = new TextField();

        Label rateLabel = new Label("Interest Rate:");
        TextField rateField = new TextField();

        Label timeLabel = new Label("Time (years):");
        TextField timeField = new TextField();

        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");

        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(e -> {
            double principal = Double.parseDouble(principalField.getText());
            double rate = Double.parseDouble(rateField.getText());
            double time = Double.parseDouble(timeField.getText());

            double interest = (principal * rate * time) / 100;
            double totalAmount = principal + interest;

            resultLabel.setText("Interest: ₦" + interest + "\nTotal Amount: ₦" + totalAmount);
        });

        // Create layout
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setVgap(10);
        root.setHgap(10);
        root.addRow(0, principalLabel, principalField);
        root.addRow(1, rateLabel, rateField);
        root.addRow(2, timeLabel, timeField);
        root.addRow(3, calculateButton);
        root.addRow(4, resultLabel);

        // Create scene and show stage
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
