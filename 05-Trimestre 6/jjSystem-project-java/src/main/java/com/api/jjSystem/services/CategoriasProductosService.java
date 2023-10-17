package com.api.jjSystem.services;

import com.api.jjSystem.Repository.CategoriasProductosRepository;
import com.api.jjSystem.models.CategoriaProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoriasProductosService {
    @Autowired
    private CategoriasProductosRepository categoriasProductosRepository;

    public CategoriaProductos createCategoria(CategoriaProductos categoriaProductos)
    {
        return categoriasProductosRepository.save(categoriaProductos);
    }
    public CategoriaProductos getCategoriaById(Integer idCategoriaProducto)
    {
        Optional<CategoriaProductos> categoriasProductos = categoriasProductosRepository.findById(idCategoriaProducto);
        return categoriasProductos.get();
    }
    public List<CategoriaProductos> getAllCategoria()
    {
        return categoriasProductosRepository.findAll();
    }
    public void deleteCategoriaById(Integer idCategoriaProducto)
    {
        categoriasProductosRepository.deleteById(idCategoriaProducto);
    }
}
