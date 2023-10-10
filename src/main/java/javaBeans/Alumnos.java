package javaBeans;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "alumno")
@XmlType(propOrder = {"nombre","edad"})
public class Alumnos {
    private String curso;
    private String nombre;
    private Integer edad;

    public Alumnos(String curso, String nombre, Integer edad) {
        this.curso = curso;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Alumnos() {
    }
@XmlAttribute(name = "curso")
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
@XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
@XmlElement(name = "edad")
    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
