package com.api.jjSystem.controllers;

import com.api.jjSystem.models.CategoriaProductos;
import com.api.jjSystem.models.CategoriaServicios;
import com.api.jjSystem.services.CategoriaProductosService;
import com.api.jjSystem.services.CategoriaServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/categoriaServicios")
public class CategoriaServiciosController {

    @Autowired
    private CategoriaServiciosService categoriaServiciosService;

    @PostMapping
    public CategoriaServicios createCategoriaServicio(CategoriaServicios categoriaServicios)
    {
        return categoriaServiciosService.createCategoriaServicio(categoriaServicios);
    }

    @GetMapping
    public List<CategoriaServicios> getAllCategoriaServicios()
    {
        return categoriaServiciosService.getAllCategoriaServicios();
    }

    @GetMapping("{idCategoriaServicio}")
    public CategoriaServicios buscarCategoriaServiciosById(Integer idCategoriaServicio)
    {
        return categoriaServiciosService.getCategoriaServicioById(idCategoriaServicio);
    }

    @DeleteMapping("{idCategoriaServicio}")
    public void deleteCategoriaServicioById(@PathVariable("idCategoriaServicio") Integer idCategoriaServicio)
    {
        categoriaServiciosService.deleteCategoriaServicios(idCategoriaServicio);
    }

}
