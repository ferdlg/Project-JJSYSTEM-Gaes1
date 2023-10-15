package com.api.jjSystem.Repository;

import com.api.jjSystem.models.ActividadesCronogramaTecnicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadesCronogramaTecnicosRepository extends JpaRepository<ActividadesCronogramaTecnicos, Integer> {
}
