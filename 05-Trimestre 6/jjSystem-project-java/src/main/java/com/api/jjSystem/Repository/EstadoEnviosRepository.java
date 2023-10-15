package com.api.jjSystem.Repository;

import com.api.jjSystem.models.EstadoEnvios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EstadoEnviosRepository extends JpaRepository<EstadoEnvios, Integer> {
}
