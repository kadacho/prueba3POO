module com.martin.viviendas {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.martin.viviendas.agregar to javafx.fxml;
    opens com.martin.viviendas.model to javafx.fxml;
    opens com.martin.viviendas.controller to javafx.fxml;
    opens com.martin.viviendas to javafx.fxml;
    exports com.martin.viviendas;
}