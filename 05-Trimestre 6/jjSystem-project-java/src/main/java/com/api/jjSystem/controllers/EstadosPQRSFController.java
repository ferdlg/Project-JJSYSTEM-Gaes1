package com.api.jjSystem.controllers;

import com.api.jjSystem.models.EstadosPQRSF;
import com.api.jjSystem.services.EstadosPQRSFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSysten/estadosPQRSF")
public class EstadosPQRSFController {

    @Autowired
    public EstadosPQRSFService estadosPQRSFService;

    @PostMapping
    public EstadosPQRSF createEstadoPQRSF(EstadosPQRSF estadosPQRSF)
    {
        return estadosPQRSFService.createEstadoPQRSF(estadosPQRSF);
    }

    @GetMapping
    public List<EstadosPQRSF> getAllEstadosPQRSF()
    {
        return estadosPQRSFService.getAllEstadosPQRSF();
    }

    @GetMapping("{idEstadoPQRSF}")
    public EstadosPQRSF buscarEstadoPQRSFById(@PathVariable Integer idEstadoPQRSF)
    {
        return estadosPQRSFService.getEstadoPQRSFById(idEstadoPQRSF);
    }

    @DeleteMapping("{idEstadoPQRSF}")
    public void deleteEstadoPQRSFById(@PathVariable("idEstadoPQRSF") Integer idEstadoPQRSF)
    {
        estadosPQRSFService.deleteEstadosPQRSF(idEstadoPQRSF);
    }
}
