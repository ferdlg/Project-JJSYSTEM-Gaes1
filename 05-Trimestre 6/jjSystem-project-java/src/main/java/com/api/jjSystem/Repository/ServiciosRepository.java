package com.api.jjSystem.Repository;

import com.api.jjSystem.models.Servicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiciosRepository extends JpaRepository<Servicios, Integer> {
}
