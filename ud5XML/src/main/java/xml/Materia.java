/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.List;


/**
 *
 * @author alumno
 */
@XmlRootElement(name = "materia")
@XmlType(propOrder = {"nombre", "profesor", "alumnos"})
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Materia {

    private String nombre, profesor;
    private Integer horas;
    private List<Alumno> alumnos;

    public Materia(String nombre, String profesor, Integer horas, List<Alumno> alumnos) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.horas = horas;
        this.alumnos = alumnos;
    }

    public Materia() {
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        String salida = "";
        for (Alumno a : alumnos) {
            salida += "\n" + a;
        }
        return "Materia{" + "nombre=" + nombre + ", profesor=" + profesor + ", horas=" + horas + ", alumnos=" + salida + '}';
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElementWrapper(name = "matriculados")
    @XmlElement(name = "alumno")
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    @XmlElement(name = "titular")
    public String getProfesor() {
        return profesor;
    }

    @XmlAttribute(name = "horas")
    public Integer getHoras() {
        return horas;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

}
