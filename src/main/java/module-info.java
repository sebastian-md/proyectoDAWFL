module com.example.proyectodawfa {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires lombok;

    opens com.example.proyectodawfa to javafx.fxml;
    exports com.example.proyectodawfa;
}