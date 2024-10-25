package com.example.Proyecto1.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class DetalleProductoModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String caracteristicas;

    @OneToOne
    @JsonBackReference // Relación inversa de ProductoModelo
    @JoinColumn(name = "producto_id")
    private ProductoModelo producto;

    // Constructor vacío
    public DetalleProductoModelo() {
    }

    // Constructor completo
    public DetalleProductoModelo(Long id, String descripcion, String caracteristicas) {
        this.id = id;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public ProductoModelo getProducto() {
        return producto;
    }

    public void setProducto(ProductoModelo producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "DetalleProductoModelo{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", caracteristicas='" + caracteristicas + '\'' +
                '}';
    }
}
