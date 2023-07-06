package biodatainfo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BiodataDetailsApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Biodata Details");

        // Create UI controls
        Label matricLabel = new Label("Matric No:");
        TextField matricTextField = new TextField();
        Label nameLabel = new Label("Name:");
        TextField nameTextField = new TextField();
        Label ageLabel = new Label("Age:");
        TextField ageTextField = new TextField();
        Label genderLabel = new Label("Gender:");
        ComboBox<String> genderComboBox = new ComboBox<>();
        genderComboBox.getItems().addAll("Male", "Female");
        Label departmentLabel = new Label("Department:");
        TextField departmentTextField = new TextField();
        Button submitButton = new Button("Submit");
        TextArea resultTextArea = new TextArea();
        resultTextArea.setEditable(false);

        // Create layout
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        root.add(matricLabel, 0, 0);
        root.add(matricTextField, 1, 0);
        root.add(nameLabel, 0, 1);
        root.add(nameTextField, 1, 1);
        root.add(ageLabel, 0, 2);
        root.add(ageTextField, 1, 2);
        root.add(genderLabel, 0, 3);
        root.add(genderComboBox, 1, 3);
        root.add(departmentLabel, 0, 4);
        root.add(departmentTextField, 1, 4);
        root.add(submitButton, 1, 5);
        root.add(resultTextArea, 0, 6, 2, 1);

        // Handle submit button click
        submitButton.setOnAction(e -> {
            String matricNo = matricTextField.getText();
            String name = nameTextField.getText();
            String age = ageTextField.getText();
            String gender = genderComboBox.getValue();
            String department = departmentTextField.getText();

            // Generate the biodata details
            StringBuilder biodataBuilder = new StringBuilder();
            biodataBuilder.append("Matric No: ").append(matricNo).append("\n");
            biodataBuilder.append("Name: ").append(name).append("\n");
            biodataBuilder.append("Age: ").append(age).append("\n");
            biodataBuilder.append("Gender: ").append(gender).append("\n");
            biodataBuilder.append("Department: ").append(department);

            // Display the biodata details
            resultTextArea.setText(biodataBuilder.toString());
        });

        // Create scene and show stage
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
