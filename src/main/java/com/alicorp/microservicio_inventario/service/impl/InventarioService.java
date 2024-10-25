package com.alicorp.microservicio_inventario.service.impl;

import com.alicorp.microservicio_inventario.exception.ProductoNotFoundException;
import com.alicorp.microservicio_inventario.model.Inventario;
import com.alicorp.microservicio_inventario.repository.InventarioRepository;
import com.alicorp.microservicio_inventario.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InventarioService implements IInventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;
    @Override
    @Transactional
    public Inventario actualizarStock(Long productoId, Integer nuevaCantidad) throws ProductoNotFoundException {
        Inventario inventario = inventarioRepository.findByProductoId(productoId)
                .orElseThrow(() -> new ProductoNotFoundException("Producto no encontrado"));

        inventario.setCantidad(nuevaCantidad);
        inventario.setFechaActualizacion(LocalDateTime.now());

        return inventarioRepository.save(inventario);
    }

    @Override
    public List<Inventario> listarInventario() {
        return inventarioRepository.findAll();
    }
}
