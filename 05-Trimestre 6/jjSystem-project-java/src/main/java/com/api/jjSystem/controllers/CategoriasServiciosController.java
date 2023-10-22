package com.api.jjSystem.controllers;

import com.api.jjSystem.models.CategoriasServicios;
import com.api.jjSystem.services.CategoriaServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.jjSystem/categoriaServicios")
public class CategoriasServiciosController {

    @Autowired
    private CategoriaServiciosService categoriaServiciosService;

    @PostMapping
    public CategoriasServicios createCategoriaServicio(CategoriasServicios categoriasServicios)
    {
        return categoriaServiciosService.createCategoriaServicio(categoriasServicios);
    }

    @GetMapping
    public List<CategoriasServicios> getAllCategoriaServicios()
    {
        return categoriaServiciosService.getAllCategoriaServicios();
    }

    @GetMapping("{idCategoriaServicio}")
    public CategoriasServicios buscarCategoriaServiciosById(Integer idCategoriaServicio)
    {
        return categoriaServiciosService.getCategoriaServicioById(idCategoriaServicio);
    }

    @DeleteMapping("{idCategoriaServicio}")
    public void deleteCategoriaServicioById(@PathVariable("idCategoriaServicio") Integer idCategoriaServicio)
    {
        categoriaServiciosService.deleteCategoriaServicios(idCategoriaServicio);
    }

}
