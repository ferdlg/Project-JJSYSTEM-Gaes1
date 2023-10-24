package com.api.jjSystem.Repository;

import com.api.jjSystem.models.EstadosEnvios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EstadosEnviosRepository extends JpaRepository<EstadosEnvios, Integer> {
}
