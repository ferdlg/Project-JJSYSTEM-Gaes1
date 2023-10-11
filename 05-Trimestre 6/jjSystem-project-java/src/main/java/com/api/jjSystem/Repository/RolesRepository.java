package com.api.jjSystem.Repository;

import com.api.jjSystem.models.Roles;
import org.springframework.data.repository.CrudRepository;
//Heredar la clase Crud que nos da los metodos necesarios
public interface RolesRepository extends CrudRepository<Roles, Integer> {
}
