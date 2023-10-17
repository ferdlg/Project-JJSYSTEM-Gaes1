package com.api.jjSystem.Repository;

import com.api.jjSystem.models.CategoriaProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasProductosRepository extends JpaRepository<CategoriaProductos, Integer> {
}
