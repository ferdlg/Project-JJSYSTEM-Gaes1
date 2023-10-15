package com.api.jjSystem.Repository;

import com.api.jjSystem.models.Envios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EnviosRepository extends JpaRepository<Envios, Integer> {

}
