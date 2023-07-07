module kilometersconverter {
    requires javafx.controls;
    requires javafx.fxml;

    opens kilometersconverter to javafx.fxml;
    exports kilometersconverter;
}
