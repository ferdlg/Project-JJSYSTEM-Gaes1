package com.api.jjSystem.Repository;

import com.api.jjSystem.models.CategoriasProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaProductosRepository extends JpaRepository<CategoriasProductos, Integer> {
}
