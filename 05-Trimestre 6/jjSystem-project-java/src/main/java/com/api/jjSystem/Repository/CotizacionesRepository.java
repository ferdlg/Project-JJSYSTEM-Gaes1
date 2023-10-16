package com.api.jjSystem.Repository;

import com.api.jjSystem.models.Cotizaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotizacionesRepository extends JpaRepository<Cotizaciones, Integer> {
}
