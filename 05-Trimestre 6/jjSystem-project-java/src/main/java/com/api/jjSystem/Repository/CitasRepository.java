package com.api.jjSystem.Repository;

import com.api.jjSystem.models.Citas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitasRepository extends JpaRepository<Citas,Integer> {
}
