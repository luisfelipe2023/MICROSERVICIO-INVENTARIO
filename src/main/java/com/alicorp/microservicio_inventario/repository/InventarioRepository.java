package com.alicorp.microservicio_inventario.repository;



import com.alicorp.microservicio_inventario.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
    Optional<Inventario> findByProductoId(Long productoId);
}
