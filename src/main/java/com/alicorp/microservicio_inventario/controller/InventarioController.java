package com.alicorp.microservicio_inventario.controller;

import com.alicorp.microservicio_inventario.exception.ProductoNotFoundException;
import com.alicorp.microservicio_inventario.model.Inventario;
import com.alicorp.microservicio_inventario.service.impl.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inventario")
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;

    @PutMapping("/{productoId}/stock")
    public ResponseEntity<Inventario> actualizarStock(@PathVariable Long productoId, @RequestBody Integer nuevaCantidad) {
        try {
            Inventario inventarioActualizado = inventarioService.actualizarStock(productoId, nuevaCantidad);
            return ResponseEntity.ok(inventarioActualizado);
        } catch (ProductoNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Inventario>> listarInventario() {
        List<Inventario> inventarios = inventarioService.listarInventario();
        return ResponseEntity.ok(inventarios);
    }
}