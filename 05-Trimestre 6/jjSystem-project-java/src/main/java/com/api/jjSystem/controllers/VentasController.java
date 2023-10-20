package com.api.jjSystem.controllers;

import com.api.jjSystem.models.Ventas;
import com.api.jjSystem.services.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    @PostMapping
    public Ventas createVenta(@RequestBody Ventas ventas)
    {
        return ventasService.createVenta(ventas);
    }

    @GetMapping
    public List<Ventas> getAllVentas()
    {
        return ventasService.getAllVentas();
    }

    @GetMapping
    public Ventas buscarVentasById(@PathVariable Integer idVenta)
    {
        return ventasService.getVentaById(idVenta);
    }

    @DeleteMapping("{idVenta}")
    public void deleteVentaById(@PathVariable("idVenta") Integer idVenta)
    {
        ventasService.deleteVentas(idVenta);
    }

}
