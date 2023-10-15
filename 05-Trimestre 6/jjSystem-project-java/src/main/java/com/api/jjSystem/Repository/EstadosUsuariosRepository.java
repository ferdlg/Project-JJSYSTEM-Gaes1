package com.api.jjSystem.Repository;

import com.api.jjSystem.models.EstadosUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadosUsuariosRepository extends JpaRepository<EstadosUsuarios, Integer> {
}
