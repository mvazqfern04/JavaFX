/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practivaexamen;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author alumno
 */
public class Pelicula {

    private String titulo;
    private LocalDate fechaPubli;
    private String director;
    private Double precio;

    public Pelicula(String titulo, LocalDate fechaPubli, String director, Double precio) {
        this.titulo = titulo;
        this.fechaPubli = fechaPubli;
        this.director = director;
        this.precio = precio;
    }

    /**
     * titulo;fecha(yyyy-mm-dd);directori;precio
     */
    public Pelicula(String peliculasCSV) {
        String campos[] = peliculasCSV.split(";");

        try {
            this.titulo = campos[0];
            this.fechaPubli = LocalDate.parse(campos[1], DateTimeFormatter.ISO_LOCAL_DATE);
            this.director = campos[2];
            this.precio = Double.parseDouble(campos[3]);
        } catch (Exception e) {
            
        }
    }
    
    public String toCSVFormat(){
        return titulo+";"+fechaPubli.format(DateTimeFormatter.ISO_DATE)+";"+director+";"+precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaPubli() {
        return fechaPubli;
    }

    public void setFechaPubli(LocalDate fechaPubli) {
        this.fechaPubli = fechaPubli;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.titulo);
        hash = 61 * hash + Objects.hashCode(this.fechaPubli);
        hash = 61 * hash + Objects.hashCode(this.director);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelicula other = (Pelicula) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        return Objects.equals(this.fechaPubli, other.fechaPubli);
    }

}
