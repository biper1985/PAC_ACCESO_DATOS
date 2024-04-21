package org.example;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "Prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Prestamo")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_Libro")
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "ID_Lector")
    private Lector lector;

    @Column(name = "Fecha_Prestamo")
    private Date fechaPrestamo;

    @Column(name = "Fecha_Devolucion")
    private Date fechaDevolucion;

    @Column(name = "Estado_Prestamo")
    private String estadoPrestamo;

    // Constructor sin argumentos requerido por Hibernate
    public Prestamo() {
    }

    // Constructor con argumentos
    public Prestamo(Libro libro, Lector lector, String fechaPrestamoStr) {
        this.libro = libro;
        this.lector = lector;

        // Convertir la cadena de fecha a un objeto Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.fechaPrestamo = dateFormat.parse(fechaPrestamoStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

// Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getEstadoPrestamo() {
        return estadoPrestamo;
    }

    public void setEstadoPrestamo(String estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }

    // Método toString para representar el préstamo como una cadena
    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", libro=" + libro +
                ", lector=" + lector +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                ", estadoPrestamo='" + estadoPrestamo + '\'' +
                '}';
    }
}
