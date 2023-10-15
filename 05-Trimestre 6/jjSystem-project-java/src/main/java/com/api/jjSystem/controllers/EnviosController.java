package com.api.jjSystem.controllers;

import com.api.jjSystem.models.Envios;
import com.api.jjSystem.services.EnviosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjsystem/envios")
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

    @GetMapping("{id}")
    public Envios buscarEnviosById (@PathVariable Integer id)
    {
        return enviosService.getEnvioById(id);
    }
    @DeleteMapping("{id}")
    public void deleteEnviosById (@PathVariable("id") Integer id)
    {
        enviosService.deleteEnvios(id);
    }
}
