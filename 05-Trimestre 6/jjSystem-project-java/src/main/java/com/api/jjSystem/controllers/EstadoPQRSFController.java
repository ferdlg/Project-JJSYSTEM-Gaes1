package com.api.jjSystem.controllers;

import com.api.jjSystem.models.EstadoPQRSF;
import com.api.jjSystem.services.EstadoPQRSFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjsystem/estadoPQRSF")
public class EstadoPQRSFController {

    @Autowired
    private EstadoPQRSFService estadoPQRSFService;

    @PostMapping
    public EstadoPQRSF createEstado (EstadoPQRSF estadoPQRSF)
    {
        return estadoPQRSFService.createEstados(estadoPQRSF);
    }

    @GetMapping
    public List<EstadoPQRSF> getAllEstados ()
    {
        return estadoPQRSFService.getAllEstados();
    }

    @GetMapping("{id}")
    public EstadoPQRSF buscarEstadoById (@PathVariable Integer id)
    {
        return estadoPQRSFService.getEstadosByid(id);
    }

    @DeleteMapping("{id}")
    public void deleteEstadoById (@PathVariable("id") Integer id)
    {
        estadoPQRSFService.deleteEstados(id);
    }
}
