package com.api.jjSystem.controllers;

import com.api.jjSystem.models.DetallesVentas;
import com.api.jjSystem.services.DetallesVentasService;
import com.api.jjSystem.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/detallesVentas")
public class DetallesVentasController {

    @Autowired
    private DetallesVentasService detallesVentasService;

    @PostMapping
    public DetallesVentas createDetalleVenta(DetallesVentas detallesVentas)
    {
        return detallesVentasService.createDetalleVenta(detallesVentas);
    }

    @GetMapping
    public List<DetallesVentas> getAllDetallesVentas(){
        return detallesVentasService.getAllDetallesVentas();
    }

    @GetMapping("{idDetalleVenta}")
    public DetallesVentas buscarDetallesVentasById(@PathVariable Integer idDetalleVenta)
    {
        return detallesVentasService.getDetallesVentasById(idDetalleVenta);
    }

    @DeleteMapping("{idDetalleVenta}")
    public void deleteProductoById(@PathVariable("idDetalleVenta") Integer idDetalleVenta)
    {
    detallesVentasService.deleteDetallesVentas(idDetalleVenta);
    }

}
