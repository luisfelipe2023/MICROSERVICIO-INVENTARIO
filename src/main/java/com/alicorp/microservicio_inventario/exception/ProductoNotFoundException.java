package com.alicorp.microservicio_inventario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductoNotFoundException extends RuntimeException {
    public ProductoNotFoundException(Long id) {
        super("Producto no encontrado con el ID: " + id);
    }

    public ProductoNotFoundException(String message) {
        super(message);
    }
}
