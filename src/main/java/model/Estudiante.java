package model;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String cif;
    private String facultad;
    private String carrera;

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, String cif, String facultad, String carrera) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cif = cif;
        this.facultad = facultad;
        this.carrera = carrera;
    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
