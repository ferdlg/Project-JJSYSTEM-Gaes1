package com.api.jjSystem.Repository;

import com.api.jjSystem.models.DetallesActividadCronograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesActividadCronogramaRepository extends JpaRepository<DetallesActividadCronograma, Integer> {
}
