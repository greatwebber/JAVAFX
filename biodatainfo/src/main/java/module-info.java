module biodatainfo {
    requires javafx.controls;
    requires javafx.fxml;

    opens biodatainfo to javafx.fxml;
    exports biodatainfo;
}
