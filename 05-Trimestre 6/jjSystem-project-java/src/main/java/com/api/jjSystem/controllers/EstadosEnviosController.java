package com.api.jjSystem.controllers;

import com.api.jjSystem.models.EstadosEnvios;
import com.api.jjSystem.services.EstadosEnviosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/estadosEnvios")
public class EstadosEnviosController {

    @Autowired
    private EstadosEnviosService estadosEnviosService;

    @PostMapping
    public EstadosEnvios createEstadoEnvio (EstadosEnvios estadosEnvios)
    {
        return estadosEnviosService.createEstadoEnvio(estadosEnvios);
    }

    @GetMapping
    public List<EstadosEnvios> getAllEstadosEnvios()
    {
        return estadosEnviosService.getAllEstadosEnvios();
    }

    @GetMapping("{idEstadoEnvio}")
    public EstadosEnvios buscarEstadosEnviosById (@PathVariable Integer idEstadoEnvio)
    {
        return estadosEnviosService.getEstadoEnvioById(idEstadoEnvio);
    }

    @DeleteMapping("{idEstadoEnvio}")
    public void deleteEstadoEnvioById (@PathVariable("idEstadoEnvio") Integer idEstadoEnvio)
    {
        estadosEnviosService.deleteEstadosEnvios(idEstadoEnvio);
    }
}
