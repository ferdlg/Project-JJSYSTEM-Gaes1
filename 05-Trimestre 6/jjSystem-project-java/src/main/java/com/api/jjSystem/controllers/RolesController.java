package com.api.jjSystem.controllers;

import com.api.jjSystem.models.Roles;
import com.api.jjSystem.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//establecer la ruta o url del controlador
@RequestMapping("api.jjSystem/roles")
public class RolesController {
    /*inyectar el servicio al controlador*/
    @Autowired
    private RolesService rolesService;

    //notaciones @Mapping para mapear y que probar en postman
    @PostMapping
    public Roles createRoles(Roles roles)
    {
     return rolesService.createRol(roles);
    }
    @GetMapping
    public List<Roles> getAllRoles()
    {
        return rolesService.getAllRoles();
    }
    @GetMapping("{idRol}")
    public Roles getRolesById(@PathVariable Integer idRol)
    {
        return rolesService.getRolByid(idRol);
    }
    @DeleteMapping("{idRol}")
    public void deleteRolesById(@PathVariable("idRol") Integer idRol)
    {
        rolesService.deleteRolesById(idRol);
    }
}
