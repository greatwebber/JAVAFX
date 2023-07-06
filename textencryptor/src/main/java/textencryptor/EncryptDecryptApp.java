package textencryptor;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EncryptDecryptApp extends Application {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final int SHIFT = 3;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Encrypt Decrypt");

        // Create UI controls
        TextArea inputTextArea = new TextArea();
        inputTextArea.setPromptText("Enter text to encrypt or decrypt");
        TextArea outputTextArea = new TextArea();
        outputTextArea.setEditable(false);
        Button encryptButton = new Button("Encrypt");
        encryptButton.setOnAction(e -> encryptText(inputTextArea, outputTextArea));
        Button decryptButton = new Button("Decrypt");
        decryptButton.setOnAction(e -> decryptText(inputTextArea, outputTextArea));

        // Create layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(inputTextArea, encryptButton, decryptButton, outputTextArea);

        // Create scene and show stage
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void encryptText(TextArea inputTextArea, TextArea outputTextArea) {
        String inputText = inputTextArea.getText();
        String encryptedText = encrypt(inputText);
        outputTextArea.setText(encryptedText);
    }

    private void decryptText(TextArea inputTextArea, TextArea outputTextArea) {
        String inputText = inputTextArea.getText();
        String decryptedText = decrypt(inputText);
        outputTextArea.setText(decryptedText);
    }

    private String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                int oldIndex = ALPHABET.indexOf(Character.toLowerCase(ch));
                int newIndex = (oldIndex + SHIFT) % ALPHABET.length();
                char newChar = ALPHABET.charAt(newIndex);
                result.append(Character.isUpperCase(ch) ? Character.toUpperCase(newChar) : newChar);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    private String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                int oldIndex = ALPHABET.indexOf(Character.toLowerCase(ch));
                int newIndex = (oldIndex - SHIFT + ALPHABET.length()) % ALPHABET.length();
                char newChar = ALPHABET.charAt(newIndex);
                result.append(Character.isUpperCase(ch) ? Character.toUpperCase(newChar) : newChar);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
