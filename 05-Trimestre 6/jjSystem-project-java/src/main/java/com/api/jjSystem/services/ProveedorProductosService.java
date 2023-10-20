package com.api.jjSystem.services;

import com.api.jjSystem.Repository.ProveedorProductosRepository;
import com.api.jjSystem.models.ProveedorProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProveedorProductosService {

    @Autowired
    private ProveedorProductosRepository proveedorProductosRepository;

    public ProveedorProductos createProveedorProducto(ProveedorProductos proveedorProducto)
    {
        return proveedorProductosRepository.save(proveedorProducto);
    }

    public ProveedorProductos getProveedorProductoById(Integer idProveedorProducto)
    {
        Optional<ProveedorProductos> proveedorProductos = proveedorProductosRepository.findById(idProveedorProducto);
        return proveedorProductos.get();
    }

    public List<ProveedorProductos> getAllProveedorProductos()
    {
        return proveedorProductosRepository.findAll();
    }

    public void deleteProveedorProductos(Integer idProveedorProducto)
    {
        proveedorProductosRepository.deleteById(idProveedorProducto);
    }
}
