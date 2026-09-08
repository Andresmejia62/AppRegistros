package com.appregistros.appregistros.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalController {
    @FXML
    private void abrirFormsEstudiante(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/appregistros/appregistros/Registro-Estudiantes.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Registro de Estudiantes");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void abrirFormsPelicula(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/appregistros/appregistros/Registro-Peliculas.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Registro de Películas");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void abrirFormsDesarrollador(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info Desarrollador");
        alert.setHeaderText(null);
        alert.setContentText("Nombre: Andres Eduardo Mejia Castro \nCif: 22011505 \nCorreo: amejia@uamv.edu.ni");
        alert.showAndWait();
        return;
    }
}
