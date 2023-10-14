package com.api.jjSystem.Repository;

import com.api.jjSystem.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

//Notacion para indicar que es un repositorio
@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

}
