module digitalclock {
    requires javafx.controls;
    requires javafx.fxml;

    opens digitalclock to javafx.fxml;
    exports digitalclock;
}
