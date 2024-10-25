package com.example.Proyecto1.Repositorio;

import com.example.Proyecto1.Modelo.DetalleProductoModelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleProductoRepositorio extends JpaRepository<DetalleProductoModelo, Long> {
}