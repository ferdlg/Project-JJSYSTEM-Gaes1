package com.api.jjSystem.controllers;

import com.api.jjSystem.models.Envios;
import com.api.jjSystem.services.EnviosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api.jjSystem/envios")
public class EnviosController {

    @Autowired
    private EnviosService enviosService;

    @PostMapping
    public Envios createEnvio(Envios envios)
    {
        return enviosService.createEnvio(envios);
    }

    @GetMapping
    public List<Envios> getAllEnvios()
    {
        return enviosService.getAllEnvios();
    }

    @GetMapping("{idEnvio}")
    public Envios buscarEnviosById (@PathVariable Integer idEnvio)
    {
        return enviosService.getEnvioById(idEnvio);
    }
    @DeleteMapping("{idEnvio}")
    public void deleteEnvioById (@PathVariable("idEnvio") Integer idEnvio)
    {
        enviosService.deleteEnvios(idEnvio);
    }
}
