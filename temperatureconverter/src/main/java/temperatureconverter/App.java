package temperatureconverter;
import javafx.geometry.Insets;
import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class App extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane root = new GridPane();
		root.setPadding(new Insets(10,10,10,10));
		root.setHgap(5);
		root.setVgap(5);
		
		Button btn = new Button();
		btn.setText("Convert");
		GridPane.setConstraints(btn,0,4);
		
		TextField resultInput = new TextField();
		GridPane.setConstraints(resultInput,0,3);

		Label resultOutput = new Label();
		GridPane.setConstraints(resultOutput,0,1);		
	
		ToggleGroup radioButtons = new ToggleGroup();
		
		RadioButton celsius = new RadioButton("Celsius");
		celsius.setSelected(true);
		GridPane.setConstraints(celsius,3,3);
		celsius.setToggleGroup(radioButtons);

		RadioButton fahrenheit = new RadioButton("Fahrenheit");
		GridPane.setConstraints(fahrenheit,3,4);
		fahrenheit.setToggleGroup(radioButtons);
		
		btn.setOnAction(event->{
			double toNum = Double.parseDouble(resultInput.getText());			
			if(celsius.isSelected()){
				double celsiusResult = (toNum-32)*5/9;
				resultOutput.setText("Result: " + new DecimalFormat("##.##").format(celsiusResult)+" C");
			}
			else {
				double fahrenheitResult = toNum*1.8+32;
				resultOutput.setText("Result: " + new DecimalFormat("##.##").format(fahrenheitResult)+" F");
			}
		});
		
		root.getChildren().addAll(celsius,fahrenheit,resultOutput,resultInput,btn);
		
		primaryStage.setTitle("Temperature Converter");
		Scene scene = new Scene(root, 350, 150);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
