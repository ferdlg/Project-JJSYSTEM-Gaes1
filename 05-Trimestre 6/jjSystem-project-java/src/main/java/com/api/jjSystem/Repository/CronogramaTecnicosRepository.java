package com.api.jjSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CronogramaTecnicosRepository extends JpaRepository<CronogramaTecnicosRepository, Integer> {
}
