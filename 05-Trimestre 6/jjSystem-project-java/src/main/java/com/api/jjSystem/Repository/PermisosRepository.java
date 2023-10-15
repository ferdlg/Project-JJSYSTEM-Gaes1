package com.api.jjSystem.Repository;

import com.api.jjSystem.models.Permisos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisosRepository extends JpaRepository<Permisos, Integer> {
}
