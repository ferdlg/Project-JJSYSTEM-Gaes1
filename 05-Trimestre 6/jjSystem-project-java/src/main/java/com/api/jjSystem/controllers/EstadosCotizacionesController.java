package com.api.jjSystem.controllers;

import com.api.jjSystem.models.EstadosCotizaciones;
import com.api.jjSystem.services.EstadosCotizacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/estadosCotizaciones")
public class EstadosCotizacionesController {

    @Autowired
    private EstadosCotizacionesService estadosCotizacionesService;

    @PostMapping
    public EstadosCotizaciones createEstadoCotizacion(EstadosCotizaciones estadosCotizaciones)
    {
        return estadosCotizacionesService.createEstadoCotizacion(estadosCotizaciones);
    }

    @GetMapping
    public List<EstadosCotizaciones> getAllEstadosCotizaciones()
    {
        return estadosCotizacionesService.getAllEstadosCotizaciones();
    }

    @GetMapping("{idEstadoCotizacion}")
    public EstadosCotizaciones buscarEstadosCotizacionesById(@PathVariable Integer idEstadoCotizacion)
    {
        return estadosCotizacionesService.getEstadoCotizacionById(idEstadoCotizacion);
    }

    @DeleteMapping("{idEstadoCotizacion}")
    public void deleteEstadoCotizacionById(@PathVariable("idEstadoCotizacion") Integer idEstadoCotizacion)
    {
        estadosCotizacionesService.deleteEstadosCotizaciones(idEstadoCotizacion);
    }

}
