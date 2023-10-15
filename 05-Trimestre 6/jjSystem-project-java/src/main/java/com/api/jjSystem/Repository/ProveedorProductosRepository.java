package com.api.jjSystem.Repository;

import com.api.jjSystem.models.ProveedorProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorProductosRepository extends JpaRepository<ProveedorProductos, Integer> {
}
