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
    public Permisos createPermiso(Permisos permisos)
    {
        return permisosService.createPermisos(permisos);
    }

    @GetMapping
    public List<Permisos> getAllPermisos ()
    {
       return permisosService.getAllPermisos();
    }

    @GetMapping("{idPermiso}")
    public Permisos buscarPermisosById (@PathVariable Integer idPermiso)
    {
        return permisosService.getPermisosById(idPermiso);
    }

    @DeleteMapping("{idPermiso}")
    public void deletePermisoById(@PathVariable("idPermiso") Integer idPermiso)
    {
        permisosService.deletePermisos(idPermiso);
    }
}
