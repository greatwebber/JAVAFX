module quadraticequation {
    requires javafx.controls;
    requires javafx.fxml;

    opens quadraticequation to javafx.fxml;
    exports quadraticequation;
}
