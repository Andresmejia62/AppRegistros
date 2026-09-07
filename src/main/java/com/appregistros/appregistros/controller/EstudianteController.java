package com.appregistros.appregistros.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class EstudianteController {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtCIF;
    @FXML
    private TextField txtFacultad;
    @FXML
    private TextField txtCarrera;
    @FXML
    private TextArea txtAreaEstudiantes;

    private final List<String> estudiantes = new ArrayList<>();

    @FXML
    private void initialize() {
        mostrarEstudiantes();
    }

    @FXML
    private void AgregarEstudiante() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cif = txtCIF.getText();
        String facultad = txtFacultad.getText();
        String carrera = txtCarrera.getText();

        if (nombre.isBlank() || apellido.isBlank() || cif.isBlank() || facultad.isBlank() || carrera.isBlank()) {
            txtAreaEstudiantes.setText("Debe llenar todos los campos.");
            return;
        }

        //cif tiene que ser int
        int cifInt;
        try {
            cifInt = Integer.parseInt(cif);
        } catch (NumberFormatException e) {
            txtAreaEstudiantes.setText("El CIF debe ser un número entero.");
            return;
        }

        String estudianteInfo = "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "CIF: " + cifInt + "\n" +
                "Facultad: " + facultad + "\n" +
                "Carrera: " + carrera + "\n\n";

        estudiantes.add(estudianteInfo);
        mostrarEstudiantes();
        limpiarCampos();
    }

    @FXML
    private void limpiarCampos() {
        txtNombre.clear();
        txtApellido.clear();
        txtCIF.clear();
        txtFacultad.clear();
        txtCarrera.clear();
    }

    @FXML
    private void MostrarEstudiantes() {
        mostrarEstudiantes();
    }

    private void mostrarEstudiantes() {
        if (estudiantes.isEmpty()) {
            txtAreaEstudiantes.setText("No hay estudiantes para mostrar.");
            return;
        }

        StringBuilder contenido = new StringBuilder();
        for (String estudiante : estudiantes) {
            contenido.append(estudiante);
        }

        txtAreaEstudiantes.setText(contenido.toString());
    }

    @FXML
    private void limpiarLista() {
        if (estudiantes.isEmpty()) {
            txtAreaEstudiantes.setText("No hay estudiantes para eliminar.");
            return;
        }
        estudiantes.remove(estudiantes.size() - 1);
        mostrarEstudiantes();
    }
}
