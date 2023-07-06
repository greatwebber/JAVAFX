module interestcalculator {
    requires javafx.controls;
    requires javafx.fxml;

    opens interestcalculator to javafx.fxml;
    exports interestcalculator;
}
