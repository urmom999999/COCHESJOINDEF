module com.example.cochesjoin {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens com.example.cochesjoin to javafx.fxml;
    exports com.example.cochesjoin;
}