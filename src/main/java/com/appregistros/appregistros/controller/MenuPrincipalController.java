package com.appregistros.appregistros.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
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
    }

    @FXML
    private void abrirHelp() {
        String helpText = "Guía de uso de AppRegistros:\n\n"
                + "Menú 'Catálogo' -> 'Registro de Estudiantes': abrirá el formulario para ingresar un estudiante.\n"
                + "  - Campos: Nombre, Apellido, CIF (número), Facultad, Carrera.\n"
                + "  - Botón 'Agregar': valida que todos los campos estén completos y que CIF sea numérico; muestra el estudiante en el área de texto.\n"
                + "  - Botón 'Eliminar último': elimina la última entrada agregada.\n"
                + "  - Menú contextual (clic derecho sobre el área): 'Eliminar último' y 'Limpiar campos'.\n\n"
                + "Menú 'Catálogo' -> 'Registro de Películas': abrirá el formulario de películas.\n"
                + "  - Campos: Nombre (título), Director, Fecha de estreno, Género, Duración.\n"
                + "  - Botón 'Agregar': valida campos obligatorios y añade la película a la tabla y al fichero 'peliculas.csv' en el directorio de trabajo.\n"
                + "  - Botón 'Limpiar': limpia los campos del formulario.\n"
                + "  - Tabla: muestra las películas cargadas (se cargan desde peliculas.csv si existe). Seleccionar una fila carga sus datos en el formulario.\n"
                + "  - Menú contextual (clic derecho sobre la tabla): 'Eliminar' borra la película seleccionada de la tabla.\n\n"
                + "Menú 'Desarrollador' -> 'Info': muestra información del autor.\n"
                + "Menú 'Ayuda' -> 'Cómo usar': muestra esta guía.\n\n"
                + "Notas de funcionamiento: \n"
                + "  - Los datos de películas se guardan en 'peliculas.csv' en el directorio desde el que ejecuta la aplicación.\n"
                + "  - Asegúrese de ejecutar la aplicación con permisos de escritura si espera que se cree/actualice el fichero.\n"
                + "  - Para ejecutar desde la línea de comandos con Maven: 'mvn clean javafx:run' (si Maven está instalado).\n"
                + "  - Para cualquier error de carga FXML, revise que los fx:id y los nombres de los manejadores (@FXML) coincidan exactamente.\n\n"
                + "Atención: esta guía resume la funcionalidad principal. Para cambios o mejoras contacte al desarrollador.";

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ayuda - Cómo usar AppRegistros");
        alert.setHeaderText(null);
        alert.setContentText(helpText);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.showAndWait();
    }
}
