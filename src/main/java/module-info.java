module io.github.Kostaflo {
    requires javafx.controls;
    requires javafx.fxml;

    opens io.github.Kostaflo to javafx.fxml;
    exports io.github.Kostaflo;
}
