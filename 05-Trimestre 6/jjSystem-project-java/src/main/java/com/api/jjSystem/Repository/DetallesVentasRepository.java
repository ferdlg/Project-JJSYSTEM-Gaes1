package com.api.jjSystem.Repository;

import com.api.jjSystem.models.DetallesVentas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesVentasRepository extends JpaRepository<DetallesVentas, Integer> {
}
