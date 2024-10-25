package com.example.Proyecto1.Modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class ProductoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;

    @OneToOne(mappedBy = "producto", cascade = CascadeType.ALL)
    @JsonManagedReference // Relación de gestión con DetalleProductoModelo
    private DetalleProductoModelo detalle;

    // Constructor vacío
    public ProductoModelo() {
    }

    // Constructor completo
    public ProductoModelo(Long id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public DetalleProductoModelo getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleProductoModelo detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "ProductoModelo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", detalle=" + detalle +
                '}';
    }
}
