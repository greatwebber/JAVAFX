module passwordprotector {
    requires javafx.controls;
    requires javafx.fxml;

    opens passwordprotector to javafx.fxml;
    exports passwordprotector;
}
