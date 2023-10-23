package com.api.jjSystem.Repository;

import com.api.jjSystem.models.EstadosCotizaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadosCotizacionesRepository extends JpaRepository<EstadosCotizaciones, Integer> {
}
