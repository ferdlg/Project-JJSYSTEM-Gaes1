package com.api.jjSystem.controllers;

import com.api.jjSystem.models.Productos;
import com.api.jjSystem.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/productos")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @PostMapping
    public Productos createProducto(Productos productos)
    {
        return productosService.createProducto(productos);
    }

    @GetMapping
    public List<Productos> getAllProductos()
    {
        return productosService.getAllProductos();
    }

    @GetMapping("{id}")
    public Productos buscarProductosById(@PathVariable Integer id)
    {
        return productosService.getProductoById(id);
    }

    public void deleteProductoById(@PathVariable("id") Integer id)
    {
        productosService.deleteProductos(id);
    }
}
