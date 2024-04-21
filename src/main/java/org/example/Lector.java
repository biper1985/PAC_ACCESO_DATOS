package org.example;

import javax.persistence.*;

@Entity
@Table(name = "lectores")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String apellido;
    private String email;

    // Constructor vacío (necesario para Hibernate)
    public Lector() {
    }

    // Constructor con todos los atributos
    public Lector(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método para obtener el nombre completo del lector
    public String getNombreCompleto() {
        return this.nombre + " " + this.apellido;
    }


    // Método toString para imprimir la información del lector
    @Override
    public String toString() {
        return "Lector{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
