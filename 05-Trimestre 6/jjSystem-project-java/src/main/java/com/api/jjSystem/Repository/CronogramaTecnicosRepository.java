package com.api.jjSystem.Repository;

import com.api.jjSystem.models.CronogramaTecnicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CronogramaTecnicosRepository extends JpaRepository<CronogramaTecnicos, Integer> {
}
