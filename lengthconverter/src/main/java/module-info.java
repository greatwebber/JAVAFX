module lengthconverter {
    requires javafx.controls;
    requires javafx.fxml;

    opens lengthconverter to javafx.fxml;
    exports lengthconverter;
}
