package com.api.jjSystem.Repository;

import com.api.jjSystem.models.EstadosCitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadosCitasRepository extends JpaRepository<EstadosCitas, Integer> {
}
