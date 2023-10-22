package com.api.jjSystem.services;

import com.api.jjSystem.Repository.CategoriaProductosRepository;
import com.api.jjSystem.models.CategoriasProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoriaProductosService {

    @Autowired
    private CategoriaProductosRepository categoriasProductosRepository;

    public CategoriasProductos createCategoriaProducto(CategoriasProductos categoriaProducto)
    {
        return categoriasProductosRepository.save(categoriaProducto);
    }

    public CategoriasProductos getCategoriaProductoById(Integer idCategoriaProducto)
    {
        Optional<CategoriasProductos> categoriasProductos = categoriasProductosRepository.findById(idCategoriaProducto);
        return categoriasProductos.get();
    }

    public List<CategoriasProductos> getAllCategoriaProductos()
    {
        return categoriasProductosRepository.findAll();
    }

    public void deleteCategoriaProductos(Integer idCategoriaProducto)
    {
        categoriasProductosRepository.deleteById(idCategoriaProducto);
    }
}
