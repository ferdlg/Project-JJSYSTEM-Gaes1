package com.api.jjSystem.controllers;

import com.api.jjSystem.models.EstadosUsuarios;
import com.api.jjSystem.services.EstadosUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/estadosUsuarios")
public class EstadosUsuariosController {

    @Autowired
    private EstadosUsuariosService estadosUsuariosService;

    @PostMapping
    public EstadosUsuarios createEstadoUsuario(EstadosUsuarios estadosUsuarios)
    {
        return estadosUsuariosService.createEstadoUsuario(estadosUsuarios);
    }

    @GetMapping
    public List<EstadosUsuarios> getAllEstadosUsuarios()
    {
        return estadosUsuariosService.getAllEstadosUsuarios();
    }

    @GetMapping("{idEstadoUsuario}")
    public EstadosUsuarios buscarEstadosUsuariosById(@PathVariable Integer idEstadoUsuario)
    {
        return estadosUsuariosService.getEstadoUsuarioById(idEstadoUsuario);
    }

    @DeleteMapping("{idEstadoUsuario}")
    public void deleteEstadoUsuarioById(@PathVariable("idEstadoUsuario") Integer idEstadoUsuario)
    {
        estadosUsuariosService.deleteEstadosUsuarios(idEstadoUsuario);
    }

}
