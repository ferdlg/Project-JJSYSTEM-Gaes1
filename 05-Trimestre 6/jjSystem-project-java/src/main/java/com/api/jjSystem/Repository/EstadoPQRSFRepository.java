package com.api.jjSystem.Repository;

import com.api.jjSystem.models.EstadoPQRSF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoPQRSFRepository extends JpaRepository <EstadoPQRSF, Integer> {
}
