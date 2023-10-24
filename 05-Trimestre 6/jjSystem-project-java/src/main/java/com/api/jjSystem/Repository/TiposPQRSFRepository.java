package com.api.jjSystem.Repository;

import com.api.jjSystem.models.TiposPQRSF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposPQRSFRepository extends JpaRepository <TiposPQRSF, Integer> {
}
