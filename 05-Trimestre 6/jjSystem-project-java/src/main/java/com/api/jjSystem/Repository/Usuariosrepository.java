package com.api.jjSystem.Repository;

import com.api.jjSystem.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Usuariosrepository extends JpaRepository<Usuarios, Integer> {
}
