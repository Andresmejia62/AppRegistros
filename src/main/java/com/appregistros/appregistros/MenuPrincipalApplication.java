package com.appregistros.appregistros;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MenuPrincipalApplication.class.getResource("Menu-principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Menu Principal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
