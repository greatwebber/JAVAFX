package digitalclock;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClockApp extends Application {

    private static final String TIME_FORMAT = "HH:mm:ss";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Digital Clock");

        // Create the label to display the current time
        Label timeLabel = new Label();
        timeLabel.setStyle("-fx-font-size: 48px;");

        // Create a timeline to update the time label every second
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), event -> {
                    SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
                    String currentTime = sdf.format(new Date());
                    timeLabel.setText(currentTime);
                }),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        // Create the root layout and add the time label
        StackPane root = new StackPane(timeLabel);
        root.setAlignment(Pos.CENTER);
        root.setPrefSize(200, 100);

        // Create the scene and show the stage
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
