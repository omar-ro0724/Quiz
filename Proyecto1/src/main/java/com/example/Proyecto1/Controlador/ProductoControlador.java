package com.example.Proyecto1.Controlador;

import com.example.Proyecto1.Modelo.ProductoModelo;
import com.example.Proyecto1.Repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @GetMapping
    public List<ProductoModelo> listarProductos() {
        return productoRepositorio.findAll();
    }

    @PostMapping
    public ProductoModelo crearProducto(@RequestBody ProductoModelo producto) {
        return productoRepositorio.save(producto);
    }

    @GetMapping("/{id}")
    public ProductoModelo obtenerProducto(@PathVariable Long id) {
        return productoRepositorio.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ProductoModelo actualizarProducto(@PathVariable Long id, @RequestBody ProductoModelo productoActualizado) {
        ProductoModelo producto = productoRepositorio.findById(id).orElse(null);
        if (producto != null) {
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            return productoRepositorio.save(producto);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoRepositorio.deleteById(id);
    }
}