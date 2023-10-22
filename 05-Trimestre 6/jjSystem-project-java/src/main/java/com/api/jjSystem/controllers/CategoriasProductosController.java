package com.api.jjSystem.controllers;

import com.api.jjSystem.models.CategoriasProductos;
import com.api.jjSystem.services.CategoriaProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/categoriasProductos")
public class CategoriasProductosController {

    @Autowired
    private CategoriaProductosService categoriaProductosService;

    @PostMapping
    public CategoriasProductos createCategoriaProducto(CategoriasProductos categoriasProductos)
    {
        return categoriaProductosService.createCategoriaProducto(categoriasProductos);
    }

    @GetMapping
    public List<CategoriasProductos> getAllCategoriaProductos()
    {
        return categoriaProductosService.getAllCategoriaProductos();
    }

    @GetMapping("{idCategoriaProducto}")
    public CategoriasProductos buscarCategoriaProductosById(@PathVariable Integer idCategoriaProducto)
    {
        return categoriaProductosService.getCategoriaProductoById(idCategoriaProducto);
    }

    @DeleteMapping("{idCategoriaProducto}")
    public void deleteProductoById(@PathVariable("idCategoriaProducto") Integer idCategoriaProducto)
    {
        categoriaProductosService.deleteCategoriaProductos(idCategoriaProducto);
    }

}