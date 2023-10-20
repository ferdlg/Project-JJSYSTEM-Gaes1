package com.api.jjSystem.controllers;

import com.api.jjSystem.models.EstadoEnvios;
import com.api.jjSystem.services.EstadoEnviosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjsystem/estadoEnvios")
public class EstadoEnviosController {

    @Autowired
    private EstadoEnviosService estadoEnviosService;

    @PostMapping
    public EstadoEnvios createEstado (EstadoEnvios estadoEnvios)
    {
        return estadoEnviosService.createEstados(estadoEnvios);
    }

    @GetMapping
    public List<EstadoEnvios> getAllEstados()
    {
        return estadoEnviosService.getAllEstados();
    }

    @GetMapping("{id}")
    public EstadoEnvios buscarEstadoById (@PathVariable Integer id)
    {
        return estadoEnviosService.getEstadosById(id);
    }

    @DeleteMapping("{id}")
    public void deleteEstadoById (@PathVariable("id") Integer id)
    {
        estadoEnviosService.deleteEstados(id);
    }
}
