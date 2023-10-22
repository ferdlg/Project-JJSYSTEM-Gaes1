package com.api.jjSystem.Repository;

import com.api.jjSystem.models.ProveedoresProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorProductosRepository extends JpaRepository<ProveedoresProductos, Integer> {
}
