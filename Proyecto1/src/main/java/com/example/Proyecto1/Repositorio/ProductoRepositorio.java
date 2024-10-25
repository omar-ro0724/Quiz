package com.example.Proyecto1.Repositorio;

import com.example.Proyecto1.Modelo.ProductoModelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<ProductoModelo, Long> {
}