package com.api.jjSystem.services;

import com.api.jjSystem.Repository.CategoriaServiciosRepository;
import com.api.jjSystem.models.CategoriasServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoriaServiciosService {

    @Autowired
    private CategoriaServiciosRepository categoriaServiciosRepository;

    public CategoriasServicios createCategoriaServicio(CategoriasServicios categoriaServicio)
    {
        return categoriaServiciosRepository.save(categoriaServicio);
    }

    public CategoriasServicios getCategoriaServicioById(Integer idCategoriaServicio)
    {
        Optional<CategoriasServicios> categoriaServicios = categoriaServiciosRepository.findById(idCategoriaServicio);
        return categoriaServicios.get();
    }

    public List<CategoriasServicios> getAllCategoriaServicios()
    {
        return categoriaServiciosRepository.findAll();
    }

    public void deleteCategoriaServicios(Integer idCategoriaServicio)
    {
        categoriaServiciosRepository.deleteById(idCategoriaServicio);
    }
}
