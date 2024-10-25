package com.example.Proyecto1.Controlador;

import com.example.Proyecto1.Modelo.DetalleProductoModelo;
import com.example.Proyecto1.Repositorio.DetalleProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-productos")
public class DetalleProductoControlador {

    @Autowired
    private DetalleProductoRepositorio detalleProductoRepositorio;

    @GetMapping
    public List<DetalleProductoModelo> listarDetalleProductos() {
        return detalleProductoRepositorio.findAll();
    }

    @PostMapping
    public DetalleProductoModelo crearDetalleProducto(@RequestBody DetalleProductoModelo detalleProducto) {
        return detalleProductoRepositorio.save(detalleProducto);
    }

    @GetMapping("/{id}")
    public DetalleProductoModelo obtenerDetalleProducto(@PathVariable Long id) {
        return detalleProductoRepositorio.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public DetalleProductoModelo actualizarDetalleProducto(@PathVariable Long id, @RequestBody DetalleProductoModelo detalleProductoActualizado) {
        DetalleProductoModelo detalleProducto = detalleProductoRepositorio.findById(id).orElse(null);
        if (detalleProducto != null) {
            detalleProducto.setDescripcion(detalleProductoActualizado.getDescripcion());
            detalleProducto.setCaracteristicas(detalleProductoActualizado.getCaracteristicas());
            return detalleProductoRepositorio.save(detalleProducto);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarDetalleProducto(@PathVariable Long id) {
        detalleProductoRepositorio.deleteById(id);
    }
}