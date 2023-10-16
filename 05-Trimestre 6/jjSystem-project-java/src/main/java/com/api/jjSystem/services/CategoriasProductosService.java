package com.api.jjSystem.services;

import com.api.jjSystem.Repository.CategoriasProductosRepository;
import com.api.jjSystem.models.CategoriasProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoriasProductosService {
    @Autowired
    private CategoriasProductosRepository categoriasProductosRepository;

    public CategoriasProductos createCategoria(CategoriasProductos categoriasProductos)
    {
        return categoriasProductosRepository.save(categoriasProductos);
    }
    public CategoriasProductos getCategoriaById(Integer idCategoriaProducto)
    {
        Optional<CategoriasProductos> categoriasProductos = categoriasProductosRepository.findById(idCategoriaProducto)
        return categoriasProductos.get();
    }
    public List<CategoriasProductos> getAllCategoria()
    {
        return categoriasProductosRepository.findAll();
    }
    public void deleteCategoriaById(Integer idCategoriaProducto)
    {
        categoriasProductosRepository.deleteById(idCategoriaProducto);
    }
}
