package quadraticequation;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class QuadraticEquationCalculator extends Application {

    private TextField aTextField, bTextField, cTextField;
    private Label resultLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Quadratic Equation Calculator");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label aLabel = new Label("Enter a:");
        grid.add(aLabel, 0, 0);

        aTextField = new TextField();
        grid.add(aTextField, 1, 0);

        Label bLabel = new Label("Enter b:");
        grid.add(bLabel, 0, 1);

        bTextField = new TextField();
        grid.add(bTextField, 1, 1);

        Label cLabel = new Label("Enter c:");
        grid.add(cLabel, 0, 2);

        cTextField = new TextField();
        grid.add(cTextField, 1, 2);

        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(e -> calculateRoots());
        grid.add(calculateButton, 0, 3, 2, 1);

        resultLabel = new Label();
        grid.add(resultLabel, 0, 4, 2, 1);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateRoots() {
        try {
            double a = Double.parseDouble(aTextField.getText());
            double b = Double.parseDouble(bTextField.getText());
            double c = Double.parseDouble(cTextField.getText());

            double discriminant = b * b - 4 * a * c;

            if (discriminant > 0) {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                resultLabel.setText("Roots: " + root1 + ", " + root2);
            } else if (discriminant == 0) {
                double root = -b / (2 * a);
                resultLabel.setText("Root: " + root);
            } else {
                resultLabel.setText("No real roots.");
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter numeric values.");
        }
    }
}