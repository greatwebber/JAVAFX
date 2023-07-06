module bminew {
    requires javafx.controls;
    requires javafx.fxml;

    opens bminew to javafx.fxml;
    exports bminew;
}
