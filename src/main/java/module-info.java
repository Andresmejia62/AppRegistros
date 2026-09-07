module com.appregistros.appregistros {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.appregistros.appregistros to javafx.fxml;
    opens com.appregistros.appregistros.controller to javafx.fxml;
    opens model to javafx.base;

    exports com.appregistros.appregistros;
    exports com.appregistros.appregistros.controller;
}