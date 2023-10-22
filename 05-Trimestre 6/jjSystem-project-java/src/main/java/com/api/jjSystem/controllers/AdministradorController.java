package com.api.jjSystem.controllers;

import com.api.jjSystem.models.Administrador;
import com.api.jjSystem.services.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/Administrador")
public class AdministradorController {
    @Autowired
    private AdministradorService administradorService;
    @PostMapping
    public Administrador createAdministrador(Administrador administrador)
    {
        return administradorService.createAdministrador(administrador);
    }
    @GetMapping
    public List<Administrador> getAllAdministrador()
    {
        return administradorService.getAllAdministrador();
    }
    @GetMapping("{idAdministrador}")
    public Administrador getAdministradorById(@PathVariable Integer idAdministrador)
    {
        return administradorService.getAdministradorById(idAdministrador);
    }

}
