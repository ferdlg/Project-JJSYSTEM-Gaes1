package com.api.jjSystem.controllers;

import com.api.jjSystem.models.Cotizaciones;
import com.api.jjSystem.services.CotizacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/cotizaciones")
public class CotizacionesController {

    @Autowired
    private CotizacionesService cotizacionesService;

    @PostMapping
    public Cotizaciones createCotizacion(Cotizaciones cotizaciones)
    {
        return cotizacionesService.createCotizacion(cotizaciones);
    }

    @GetMapping
    public List<Cotizaciones> getAllCotizaciones()
    {
        return cotizacionesService.getAllCotizaciones();
    }

    @GetMapping("{idCotizacion}")
    public Cotizaciones buscarCotizacionesById(@PathVariable Integer idCotizacion)
    {
        return cotizacionesService.getCotizacionesById(idCotizacion);
    }

    @DeleteMapping("{idCotizacion}")
    public void deleteCotizacionById(@PathVariable("{idCotizacion}") Integer idCotizacion)
    {
        cotizacionesService.deleteCotizacion(idCotizacion);
    }

}
