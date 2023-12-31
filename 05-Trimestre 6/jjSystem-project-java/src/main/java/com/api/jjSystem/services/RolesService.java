package com.api.jjSystem.services;

import com.api.jjSystem.Repository.RolesRepository;
import com.api.jjSystem.models.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class RolesService {
    //notacion para inyectar servicio al repositorio de la clase Roles
    @Autowired
    private RolesRepository rolesRepository;
    public Roles createRol(Roles roles)
    {
        return rolesRepository.save(roles);
    }
    public Roles getRolByid(Integer idRol)
    {
        Optional<Roles> roles = rolesRepository.findById(idRol);
        return roles.get();
    }

    public List<Roles> getAllRoles()
    {
        return rolesRepository.findAll();
    }
    public void deleteRolesById(Integer idRol)
    {
        rolesRepository.deleteById(idRol);
    }
}
