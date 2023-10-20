package com.api.jjSystem.controllers;

import com.api.jjSystem.models.Servicios;
import com.api.jjSystem.services.ServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/servicios")
public class ServiciosController {

    @Autowired
    private ServiciosService serviciosService;

    @PostMapping
    public Servicios createServicio(Servicios servicios)
    {
        return serviciosService.createServicio(servicios);
    }

    @GetMapping
    public List<Servicios> getAllServicios()
    {
        return serviciosService.getAllServicios();
    }

    @GetMapping("{idServicio}")
    public Servicios buscarServiciosById(@PathVariable Integer idServicio)
    {
        return serviciosService.getServicioById(idServicio);
    }

    @DeleteMapping("{idServicio}")
    public void deleteServicioById(@PathVariable("{idServicio}") Integer idServicio)
    {
        serviciosService.deleteServicios(idServicio);
    }

}
