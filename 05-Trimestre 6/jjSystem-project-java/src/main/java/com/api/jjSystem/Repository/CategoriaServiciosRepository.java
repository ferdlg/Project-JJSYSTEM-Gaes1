package com.api.jjSystem.Repository;

import com.api.jjSystem.models.CategoriasServicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaServiciosRepository extends JpaRepository<CategoriasServicios, Integer> {
}
