module com.example.raytracer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.raytracer to javafx.fxml;
    exports com.example.raytracer;
}