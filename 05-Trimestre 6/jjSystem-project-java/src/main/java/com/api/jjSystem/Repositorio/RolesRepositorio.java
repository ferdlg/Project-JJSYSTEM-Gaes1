package com.api.jjSystem.Repositorio;

import com.api.jjSystem.modelos.Roles;
import org.springframework.data.repository.CrudRepository;
//Heredar la clase Crud que nos da los metodos necesarios
public interface RolesRepositorio extends CrudRepository<Roles, Integer> {
}
