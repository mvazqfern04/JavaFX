/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 *
 * @author alumno
 */
@XmlRootElement(name = "alumno")
@XmlType(propOrder = {"nombre", "apellidos", "nota"})
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Alumno {

    private Integer indentificador, nota;
    private String nombre, apellidos;

    @XmlAttribute(name = "id")
    public Integer getIndentificador() {
        return indentificador;
    }
    @XmlElement(name = "calificacion")
    public Integer getNota() {
        return nota;
    }
    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }
    @XmlElement(name = "apellidos")
    public String getApellidos() {
        return apellidos;
    }

    public void setIndentificador(Integer indentificador) {
        this.indentificador = indentificador;
    }


    public void setNota(Integer nota) {
        this.nota = nota;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Alumno() {
    }

    public Alumno(Integer indentificador, Integer nota, String nombre, String apellidos) {
        this.indentificador = indentificador;
        this.nota = nota;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Alumno{" + "indentificador=" + indentificador + ", nota=" + nota + ", nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }

}
