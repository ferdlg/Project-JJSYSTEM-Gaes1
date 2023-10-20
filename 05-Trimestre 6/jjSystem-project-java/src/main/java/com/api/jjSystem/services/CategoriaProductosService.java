package com.api.jjSystem.services;

import com.api.jjSystem.Repository.CategoriaProductosRepository;
import com.api.jjSystem.models.CategoriaProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoriaProductosService {

    @Autowired
    private CategoriaProductosRepository categoriasProductosRepository;

    public CategoriaProductos createCategoriaProducto(CategoriaProductos categoriaProducto)
    {
        return categoriasProductosRepository.save(categoriaProducto);
    }

    public CategoriaProductos getCategoriaProductoById(Integer idCategoriaProducto)
    {
        Optional<CategoriaProductos> categoriasProductos = categoriasProductosRepository.findById(idCategoriaProducto);
        return categoriasProductos.get();
    }

    public List<CategoriaProductos> getAllCategoriaProductos()
    {
        return categoriasProductosRepository.findAll();
    }

    public void deleteCategoriaProductos(Integer idCategoriaProducto)
    {
        categoriasProductosRepository.deleteById(idCategoriaProducto);
    }
}
