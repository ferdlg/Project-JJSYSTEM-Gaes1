package com.api.jjSystem.services;

import com.api.jjSystem.Repository.CategoriaServiciosRepository;
import com.api.jjSystem.models.CategoriaServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoriaServiciosService {
    @Autowired
    private CategoriaServiciosRepository categoriaServiciosRepository;
    public CategoriaServicios createCategoria(CategoriaServicios categoriaServicios)
    {
        return categoriaServiciosRepository.save(categoriaServicios);
    }
    public CategoriaServicios getcategoriaById(Integer idCategoriaServicio)
    {
        Optional<CategoriaServicios> categoriaServicios = categoriaServiciosRepository.findById(idCategoriaServicio);
        return categoriaServicios.get();
    }
    public List<CategoriaServicios> getAllCategoria()
    {
        return categoriaServiciosRepository.findAll();
    }
    public void deleteCategoriaById(Integer idCategoriaServicio)
    {
        categoriaServiciosRepository.deleteById(idCategoriaServicio);
    }
}
