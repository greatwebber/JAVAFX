module percentagecalculator {
    requires javafx.controls;
    requires javafx.fxml;

    opens percentagecalculator to javafx.fxml;
    exports percentagecalculator;
}
