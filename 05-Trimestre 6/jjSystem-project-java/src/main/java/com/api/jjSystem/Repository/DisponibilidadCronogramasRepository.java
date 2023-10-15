package com.api.jjSystem.Repository;

import com.api.jjSystem.models.DisponibilidadCronogramas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisponibilidadCronogramasRepository extends JpaRepository<DisponibilidadCronogramas, Integer> {
}
