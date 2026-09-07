package com.appregistros.appregistros.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Peliculas;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class PeliculaController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDirector;
    @FXML
    private TextField txtFechaEstreno;
    @FXML
    private TextField txtGenero;
    @FXML
    private TextField txtDuracion;

    @FXML
    private TableView<Peliculas> tblPeliculas;
    @FXML
    private TableColumn<Peliculas, String> colNombre;
    @FXML
    private TableColumn<Peliculas, String> colDirector;
    @FXML
    private TableColumn<Peliculas, String> colFechaEstreno;
    @FXML
    private TableColumn<Peliculas, String> colGenero;
    @FXML
    private TableColumn<Peliculas, String> colDuracion;

    private final ObservableList<Peliculas> peliculas = FXCollections.observableArrayList();
    private final Path dataFile = Paths.get("peliculas.csv");

    @FXML
    private void initialize() {
        configureTable();
        configureTableSelection();
        tblPeliculas.setItems(peliculas);

        // cargar desde archivo si existe
        loadPeliculasFromFile();
    }

    @FXML
    private void guardarPelicula() {
        if (!validateForm()) return;

        Peliculas pelicula = new Peliculas(
                txtNombre.getText(),
                txtDirector.getText(),
                txtFechaEstreno.getText(),
                txtGenero.getText(),
                txtDuracion.getText()
        );

        peliculas.add(pelicula);
        savePeliculaToFile(pelicula);
        limpiarCampos();
    }

    @FXML
    private void limpiarCampos() {
        txtNombre.clear();
        txtDirector.clear();
        txtFechaEstreno.clear();
        txtGenero.clear();
        txtDuracion.clear();
    }

    @FXML
    private void limpiarLista() {
            //borrar el ultimo agregado
        if (!peliculas.isEmpty()) {
            peliculas.remove(peliculas.size() - 1);
        }
    }

    private void configureTable() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDirector.setCellValueFactory(new PropertyValueFactory<>("director"));
        colFechaEstreno.setCellValueFactory(new PropertyValueFactory<>("fechaEstreno"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
    }

    private void configureTableSelection() {
        tblPeliculas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                loadProductIntoForm(newValue);
            }
        });
    }

    private void loadProductIntoForm(Peliculas pelicula) {
        txtNombre.setText(pelicula.getNombre());
        txtDirector.setText(pelicula.getDirector());
        txtFechaEstreno.setText(pelicula.getFechaEstreno());
        txtGenero.setText(pelicula.getGenero());
        txtDuracion.setText(pelicula.getDuracion());
    }

    private boolean validateForm() {
        String nombre = txtNombre.getText();
        String director = txtDirector.getText();
        String fechaEstreno = txtFechaEstreno.getText();
        String genero = txtGenero.getText();
        String duracion = txtDuracion.getText();

        if (nombre.isBlank() || director.isBlank() || fechaEstreno.isBlank() || genero.isBlank() || duracion.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Campos obligatorios!");
            alert.showAndWait();
            return false;
        }

        return true;
    }

    private void loadPeliculasFromFile() {
        if (!Files.exists(dataFile)) return;
        try {
            List<String> lines = Files.readAllLines(dataFile, StandardCharsets.UTF_8);
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",", -1);
                if (parts.length >= 5) {
                    Peliculas p = new Peliculas(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    peliculas.add(p);
                }
            }
        } catch (IOException e) {
            showError("No se pudo leer el fichero de datos: " + e.getMessage());
        }
    }

    private void savePeliculaToFile(Peliculas p) {
        String line = String.join(",",
                escapeCsv(p.getNombre()),
                escapeCsv(p.getDirector()),
                escapeCsv(p.getFechaEstreno()),
                escapeCsv(p.getGenero()),
                escapeCsv(p.getDuracion())
        ) + System.lineSeparator();

        try {
            Files.write(dataFile, line.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            showError("No se pudo guardar la película: " + e.getMessage());
        }
    }

    private String escapeCsv(String s) {
        if (s == null) return "";
        return s.replace("\n", " ").replace("\r", " ").replace(",", ";");
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
