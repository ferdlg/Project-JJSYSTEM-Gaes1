package com.api.jjSystem.Repository;

import com.api.jjSystem.models.PQRSF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PQRSFRepository extends JpaRepository <PQRSF, Integer> {
}
