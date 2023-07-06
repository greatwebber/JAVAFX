package bminew;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.*;

/**
 * @author dingfei
 * @version 1.0.1
 */
public class ConfirmBox {
    public static final int DEFAULT_MIN_WIDTH = 200;
    public static final int DEFAULT_MIN_Height = 120;

    private static Boolean response;

    /**
     * pop out a confirm message box with given width and height that prompts the user to click on "yer" or "no",
     * and return the user's response as a boolean, where "Yes" is true, "No" is false, and unexpected close is null.
     * The message box can adjust its size based on contents given. The box means to block the functionality of other
     * windows until a response has been made.
     * @param title a title that will be displayed on the tab
     * @param message a message that prompts the user to click on given options
     * @param minWidth minimum width of the window
     * @param minHeight minimum height of the window
     * @return user's response, where true means "yes", false means "no", and null means unexpected close
     */
    public static Boolean display(String title, String message, int minWidth, int minHeight) {
        // create the window
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(minWidth);
        window.setMinHeight(minHeight);
        window.setOnCloseRequest(e -> {
            ConfirmBox.response = null;
            window.close();
        });

        // create the message label;
        Label label = new Label();
        label.setText(message);

        // create two buttons;
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        // assign functionality to the two buttons;
        yesButton.setOnAction(e -> {
            ConfirmBox.response = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            ConfirmBox.response = false;
            window.close();
        });

        // create proper layout and put in components. The main layout is a vertical box, top of which contains the
        // label message, and bottom of which contains a border box. On the left and right of the border box contains
        // "Yes" and "No" button.
        BorderPane subLayout = new BorderPane();
        int sideMargin = (int) (minWidth * 1.0 / 4);
        subLayout.setPadding(new Insets(0, sideMargin,0, sideMargin));
        subLayout.setLeft(yesButton);
        subLayout.setRight(noButton);

        VBox layout = new VBox();
        layout.setSpacing(20);
        layout.getChildren().addAll(label, subLayout);
        layout.setAlignment(Pos.CENTER);

        // create scene, apply layout, and set on stage
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return ConfirmBox.response;
    }

    /**
     * pop out an confirm message box with default width and height that prompts the user to click on "yer" or "no",
     * and return the user's response as a boolean, where "Yes" is true, "No" is false, and unexpected close is null.
     * The message box can adjust its size based on contents given. The box means to block the functionality of other
     * windows until a response has been made.
     * @param title a title that will be displayed on the tab
     * @param message a message that prompts the user to click on given options
     * @return user's response, where true means "yes", false means "no", and null means unexpected close
     */
    public static Boolean display(String title, String message) {
        return ConfirmBox.display(title, message, ConfirmBox.DEFAULT_MIN_WIDTH, ConfirmBox.DEFAULT_MIN_Height);
    }
}