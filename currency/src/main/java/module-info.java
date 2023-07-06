module currency {
    requires javafx.controls;
    requires javafx.fxml;

    opens currency to javafx.fxml;
    exports currency;
}
