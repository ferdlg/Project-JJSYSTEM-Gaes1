package com.api.jjSystem.Repository;

import com.api.jjSystem.models.Tecnicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicosRepository extends JpaRepository<Tecnicos, Integer> {
}
