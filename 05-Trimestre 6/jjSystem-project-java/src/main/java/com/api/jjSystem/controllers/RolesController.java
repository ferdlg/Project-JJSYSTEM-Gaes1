package com.api.jjSystem.controllers;

import com.api.jjSystem.models.Roles;
import com.api.jjSystem.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.List;

@RestController
//establecer la ruta o url del controlador
@RequestMapping("jjSystem/roles")
public class RolesController {
    //inyectar el servicio al controlador
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
    @GetMapping("{id}")
    public Roles getRolesById(@PathVariable Integer id)
    {
        return rolesService.getRolByid(id);
    }

    public void deleteRolesById(@PathVariable("id") Integer id)
    {
        rolesService.deleteRolesById(id);
    }
}
