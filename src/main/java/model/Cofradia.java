package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cofradia")
public class Cofradia {
    private String nombre;
    private int anioFundacion;
    private int numeroHermanos;
    private String ciudad;

    // ✅ Constructor sin parámetros necesario para JAXB y JSON
    public Cofradia() {
    }

    // Constructor completo que tú ya tenías
    public Cofradia(String nombre, int anioFundacion, int numeroHermanos, String ciudad) {
        this.nombre = nombre;
        this.anioFundacion = anioFundacion;
        this.numeroHermanos = numeroHermanos;
        this.ciudad = ciudad;
    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public int getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(int anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    @XmlElement
    public int getNumeroHermanos() {
        return numeroHermanos;
    }

    public void setNumeroHermanos(int numeroHermanos) {
        this.numeroHermanos = numeroHermanos;
    }

    @XmlElement
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Cofradia{" +
                "nombre='" + nombre + '\'' +
                ", anioFundacion=" + anioFundacion +
                ", numeroHermanos=" + numeroHermanos +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
