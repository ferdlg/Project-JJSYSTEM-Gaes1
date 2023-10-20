package com.api.jjSystem.controllers;

import com.api.jjSystem.models.CategoriaProductos;
import com.api.jjSystem.services.CategoriaProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/categoriasProductos")
public class CategoriaProductosController {

    @Autowired
    private CategoriaProductosService categoriaProductosService;

    @PostMapping
    public CategoriaProductos createCategoriaProducto(CategoriaProductos categoriaProductos)
    {
        return categoriaProductosService.createCategoriaProducto(categoriaProductos);
    }

    @GetMapping
    public List<CategoriaProductos> getAllCategoriaProductos()
    {
        return categoriaProductosService.getAllCategoriaProductos();
    }

    @GetMapping("{idCategoriaProducto}")
    public CategoriaProductos buscarCategoriaProductosById(@PathVariable Integer idCategoriaProducto)
    {
        return categoriaProductosService.getCategoriaProductoById(idCategoriaProducto);
    }

    @DeleteMapping("{idCategoriaProducto}")
    public void deleteProductoById(@PathVariable("idCategoriaProducto") Integer idCategoriaProducto)
    {
        categoriaProductosService.deleteCategoriaProductos(idCategoriaProducto);
    }

}