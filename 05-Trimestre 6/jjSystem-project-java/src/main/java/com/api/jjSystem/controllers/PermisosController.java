package com.api.jjSystem.controllers;

import com.api.jjSystem.models.Permisos;
import com.api.jjSystem.services.PermisosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/permisos")
public class PermisosController {

    @Autowired
    private PermisosService permisosService;

    @PostMapping
    public Permisos createPermisos (Permisos permisos)
    {
        return permisosService.createPermisos(permisos);
    }

    @GetMapping
    public List<Permisos> getAllPermisos ()
    {
       return permisosService.getAllPermisos();
    }

    @GetMapping("{id}")
    public Permisos buscarPermisoById (@PathVariable Integer id)
    {
        return permisosService.getPermisosById(id);
    }

    @DeleteMapping("{id}")
    public void deletePermisoById (@PathVariable("id") Integer id)
    {
        permisosService.deletePermisos(id);
    }
}
