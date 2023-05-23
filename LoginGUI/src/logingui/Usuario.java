/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logingui;

import java.util.Objects;

/**
 *
 * @author alumno
 */
public class Usuario {

    private String nombreUsr;
    private String contrasena;
    private boolean bloqueado;
    private String nombre;
    private String apellido1;
    private String apellido2;

    public String[] convertirLinea(String linea) {
        String[] cadena = linea.split(";");
        return cadena;
    }

    public Usuario(String nombreUsr, String contrasena) {
        this.nombreUsr = nombreUsr;
        this.contrasena = contrasena;
    }
    
    public Usuario(String linea) {
        String[] cadena = convertirLinea(linea);
        this.nombreUsr = cadena[0];
        this.contrasena = cadena[1];
        boolean bloqueo = cadena[2].equals("true");
        this.bloqueado = bloqueo;
        this.nombre = cadena[3];
        this.apellido1 = cadena[4];
        this.apellido2 = cadena[5];
    }

    public Usuario(String nombreUsr, String contrasena, boolean bloqueado, String nombre, String apellido1,String apellido2) {
        this.nombreUsr = nombreUsr;
        this.contrasena = contrasena;
        this.bloqueado = bloqueado;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public String getNombreUsr() {
        return nombreUsr;
    }

    public void setNombreUsr(String nombreUsr) {
        this.nombreUsr = nombreUsr;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido1;
    }

    public void setApellido(String apellido) {
        this.apellido1 = apellido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nombreUsr);
        hash = 37 * hash + Objects.hashCode(this.contrasena);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nombreUsr, other.nombreUsr)) {
            return false;
        }
        return Objects.equals(this.contrasena, other.contrasena);
    }

    

    @Override
    public String toString() {
        return "Usuario[" + "nombreUsr=" + nombreUsr + ", contrasena=" + contrasena + ", bloqueado=" + bloqueado + ", nombre=" + nombre + ", apellido=" + apellido1 + ", "+"Apellido2: "+apellido2+']';
    }

}
