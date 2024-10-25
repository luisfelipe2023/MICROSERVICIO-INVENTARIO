package com.alicorp.microservicio_inventario.service;

import com.alicorp.microservicio_inventario.exception.ProductoNotFoundException;
import com.alicorp.microservicio_inventario.model.Inventario;

import java.util.List;

public interface IInventarioService {
    Inventario actualizarStock(Long productoId, Integer nuevaCantidad) throws ProductoNotFoundException;
    List<Inventario> listarInventario();

}
