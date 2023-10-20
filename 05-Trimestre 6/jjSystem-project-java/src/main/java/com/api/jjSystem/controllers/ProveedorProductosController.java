package com.api.jjSystem.controllers;

import com.api.jjSystem.models.ProveedorProductos;
import com.api.jjSystem.services.ProveedorProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api..jjSystem/proveedorProductos")
public class ProveedorProductosController {

    @Autowired
    private ProveedorProductosService proveedorProductosService;

    @PostMapping
    public ProveedorProductos createProveedorProducto(ProveedorProductos proveedorProductos)
    {
        return proveedorProductosService.createProveedorProducto(proveedorProductos);
    }

    @GetMapping
    public List<ProveedorProductos> getAllProveedorProductos()
    {
        return proveedorProductosService.getAllProveedorProductos();
    }

    @GetMapping("{idProveedorProducto}")
    public ProveedorProductos buscarProveedorProductosByID(@PathVariable Integer idProveedorProducto)
    {
        return proveedorProductosService.getProveedorProductoById(idProveedorProducto);
    }

    @DeleteMapping("{idProveedorProducto}")
    public void deleteProveedorProductoByID(@PathVariable("idProveedorProducto") Integer idProveedorProducto)
    {
        proveedorProductosService.deleteProveedorProductos(idProveedorProducto);
    }
}
