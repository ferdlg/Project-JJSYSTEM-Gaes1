package com.api.jjSystem.controllers;

import com.api.jjSystem.models.ProveedoresProductos;
import com.api.jjSystem.services.ProveedorProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/proveedoresProductos")
public class ProveedoresProductosController {

    @Autowired
    private ProveedorProductosService proveedorProductosService;

    @PostMapping
    public ProveedoresProductos createProveedorProducto(ProveedoresProductos proveedoresProductos)
    {
        return proveedorProductosService.createProveedorProducto(proveedoresProductos);
    }

    @GetMapping
    public List<ProveedoresProductos> getAllProveedorProductos()
    {
        return proveedorProductosService.getAllProveedorProductos();
    }

    @GetMapping("{idProveedorProducto}")
    public ProveedoresProductos buscarProveedorProductosByID(@PathVariable Integer idProveedorProducto)
    {
        return proveedorProductosService.getProveedorProductoById(idProveedorProducto);
    }

    @DeleteMapping("{idProveedorProducto}")
    public void deleteProveedorProductoByID(@PathVariable("idProveedorProducto") Integer idProveedorProducto)
    {
        proveedorProductosService.deleteProveedorProductos(idProveedorProducto);
    }
}
