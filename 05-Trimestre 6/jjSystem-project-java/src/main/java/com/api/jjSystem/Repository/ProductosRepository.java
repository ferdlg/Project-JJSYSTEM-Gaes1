package com.api.jjSystem.Repository;

import com.api.jjSystem.models.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
}
