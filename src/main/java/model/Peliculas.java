package model;

public class Peliculas {
    private String Nombre;
    private String Director;
    private String FechaEstreno;
    private String Genero;
    private String Duracion;

    public Peliculas() {
    }

    public Peliculas(String nombre, String director, String fechaEstreno, String genero, String duracion) {
        Nombre = nombre;
        Director = director;
        FechaEstreno = fechaEstreno;
        Genero = genero;
        Duracion = duracion;
    }

    // Getters and Setters

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getFechaEstreno() {
        return FechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        FechaEstreno = fechaEstreno;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String duracion) {
        Duracion = duracion;
    }
}
